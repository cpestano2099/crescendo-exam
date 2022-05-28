package co.crescendo.exam.service.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class BusinessReview {

    private String id;
    private String url;
    private String text;
    private int rating;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("time_created")
    private LocalDateTime timeCreated;
    private User user;

    private FaceAnnotationResponse faceAnnotationResponse;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FaceAnnotationResponse getFaceAnnotationResponse() {
        return faceAnnotationResponse;
    }

    public void setFaceAnnotationResponse(FaceAnnotationResponse faceAnnotationResponse) {
        this.faceAnnotationResponse = faceAnnotationResponse;
    }
}
