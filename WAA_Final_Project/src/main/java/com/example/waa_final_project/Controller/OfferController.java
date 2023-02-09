package com.example.waa_final_project.Controller;

import com.example.waa_final_project.Entity.Offer;
import com.example.waa_final_project.Service.OfferService;
import com.example.waa_final_project.aop.annotation.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/offers")
public class OfferController {
    @Autowired
    OfferService offerService;
//    @SendEmail
//    @PostMapping
//    public String sendOffer(@RequestBody Offer offer){
//        offerService.sendOffer(offer);
//        return "sent successfully";
//    }

    @GetMapping("/{id}")
    public Offer getOfferDetails(@PathVariable("id") long id) {
        return offerService.findAllById(id);
    }

    @PutMapping("/{id}/approve")
    public String updateStatusApproved(@PathVariable("id") long id) {
        offerService.updateAcceptedOfferStatus(id, "Approved");
        return "offer accepted";
    }

    @PutMapping("/{id}/reject")
    public String updateStatusRejected(@PathVariable("id") long id) {
        offerService.updateRejectedOfferStatus(id, "Rejected");
        return "offer rejected";
    }

    @PutMapping("/{id}/contingent")
    public String updateContingentOfferStatus(@PathVariable("id") long id) {
        offerService.updateContingentOfferStatus(id, "Contingent");
        return "offer Contingent";
    }

    @DeleteMapping("/{id}")
    public void deleteOffer(@PathVariable long id) {
        offerService.deleteOffer(id);
    }

}
