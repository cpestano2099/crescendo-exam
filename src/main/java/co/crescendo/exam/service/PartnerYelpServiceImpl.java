package co.crescendo.exam.service;

import co.crescendo.exam.util.RestTemplateUtil;
import co.crescendo.exam.service.response.BusinessReviewResponse;
import co.crescendo.exam.service.response.BusinessReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartnerYelpServiceImpl implements PartnerYelpService {

    @Value("${yelp.base.path}")
    private String yelpBasePath;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Autowired
    private DetectFacesGcsServiceImpl detectFacesGcsService;

    @Override
    public List<BusinessReview> getBusinessReview(String businessId) {

        HttpEntity request = new HttpEntity(restTemplateUtil.createRequestHeaders());
        ResponseEntity<BusinessReviewResponse> response = restTemplate.exchange(yelpBasePath + "/v3/businesses/"+ businessId +"/reviews", HttpMethod.GET, request, BusinessReviewResponse.class);

        if(response.getBody() != null){
            return response.getBody().getReviews();
        }

        return new ArrayList<>();
    }
}
