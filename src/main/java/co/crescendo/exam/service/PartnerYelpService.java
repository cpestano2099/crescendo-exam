package co.crescendo.exam.service;

import co.crescendo.exam.service.response.BusinessReview;

import java.util.List;

public interface PartnerYelpService {

    List<BusinessReview> getBusinessReview(String businessId);

}
