package co.crescendo.exam.service;

import co.crescendo.exam.service.response.FaceAnnotationResponse;

import java.io.IOException;

public interface DetectFacesGcsService {

    FaceAnnotationResponse detectFaces(String path, int maxResults) throws IOException;

}
