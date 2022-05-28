package co.crescendo.exam.controller;

import co.crescendo.exam.service.PartnerYelpService;
import co.crescendo.exam.service.response.BusinessReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("businesses/")
public class PartnerYelpController {

    @Autowired
    private PartnerYelpService partnerYelpService;

    @GetMapping("{businessId}/reviews")
    public List<BusinessReview> getBusinessReview(@PathVariable String businessId){
        return partnerYelpService.getBusinessReview(businessId);
    }

}
