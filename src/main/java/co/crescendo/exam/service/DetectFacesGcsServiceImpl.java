package co.crescendo.exam.service;


import co.crescendo.exam.service.response.FaceAnnotationResponse;
import com.google.api.services.vision.v1.Vision;
import com.google.api.services.vision.v1.model.*;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DetectFacesGcsServiceImpl implements DetectFacesGcsService {

  @Autowired
  private Vision vision;

  public FaceAnnotationResponse detectFaces(String path, int maxResults) throws IOException {

    if(path == null){
      return null;
    }

    AnnotateImageRequest request =
            new AnnotateImageRequest()
                    .setImage(new Image().setSource(new ImageSource().setImageUri(path)))
                    .setFeatures(
                            ImmutableList.of(
                                    new Feature().setType("FACE_DETECTION").setMaxResults(maxResults)));
    Vision.Images.Annotate annotate =
            vision
                    .images()
                    .annotate(new BatchAnnotateImagesRequest().setRequests(ImmutableList.of(request)));

    annotate.setDisableGZipContent(true);

    BatchAnnotateImagesResponse batchResponse = annotate.execute();
    assert batchResponse.getResponses().size() == 1;
    AnnotateImageResponse response = batchResponse.getResponses().get(0);
    if (response.getFaceAnnotations() == null) {
      FaceAnnotationResponse data = new FaceAnnotationResponse();
      data.setRemarks("Nothing found. Image has no human face emotion detected.");
      return data;
    }

    List<FaceAnnotation> faceAnnotations = new ArrayList<>();
    for (FaceAnnotation faceAnnotation : response.getFaceAnnotations()) {
      if ("VERY_LIKELY".equals(faceAnnotation.getJoyLikelihood()) ||
              "VERY_LIKELY".equals(faceAnnotation.getSorrowLikelihood())) {
        faceAnnotations.add(faceAnnotation);
      }
    }

    FaceAnnotationResponse data = new FaceAnnotationResponse();
    if(faceAnnotations != null && faceAnnotations.isEmpty()){
      data.setRemarks("Has no VERY_LIKELY joyLikelihood or sorrowLikelihood");
    }else{
      data.setFaceAnnotations(faceAnnotations);
      data.setRemarks("Has VERY_LIKELY joyLikelihood or sorrowLikelihood");
    }

    return data;
  }

}
