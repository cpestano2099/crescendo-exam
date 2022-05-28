package co.crescendo.exam.service.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BusinessReviewResponse {

    private List<BusinessReview> reviews;

    private Integer total;

    @JsonProperty("possible_languages")
    private List<String> possibleLanguages;

    public List<BusinessReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<BusinessReview> reviews) {
        this.reviews = reviews;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<String> getPossibleLanguages() {
        return possibleLanguages;
    }

    public void setPossibleLanguages(List<String> possibleLanguages) {
        this.possibleLanguages = possibleLanguages;
    }
}
