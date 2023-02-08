package com.example.waa_final_project.Controller;

import com.example.waa_final_project.Entity.Offer;
import com.example.waa_final_project.Service.OfferService;
import com.example.waa_final_project.aop.annotation.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/offers")
public class OfferController {
    @Autowired
    OfferService    offerService;
    @SendEmail
    @PostMapping
    public String sendOffer(@RequestBody Offer offer){
        offerService.sendOffer(offer);
        return "sent successfully";
    }

    @PutMapping("/owner/{id}")
    public String updateStatus(@PathVariable("id") long id, @RequestParam(value = "status", required = false) String status){
        offerService.updateOfferStatus(id, status);
        return (status.equals("accepted"))? "offer accepted" : "offer rejected";
    }
}
