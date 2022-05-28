package co.crescendo.exam.service.response;

import com.google.api.services.vision.v1.model.FaceAnnotation;

import java.util.ArrayList;
import java.util.List;

public class FaceAnnotationResponse {

    private List<FaceAnnotation> faceAnnotations = new ArrayList<>();

    private String remarks;

    public List<FaceAnnotation> getFaceAnnotations() {
        return faceAnnotations;
    }

    public void setFaceAnnotations(List<FaceAnnotation> faceAnnotations) {
        this.faceAnnotations = faceAnnotations;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
