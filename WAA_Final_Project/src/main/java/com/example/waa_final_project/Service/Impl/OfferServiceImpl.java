package com.example.waa_final_project.Service.Impl;

import com.example.waa_final_project.Entity.Offer;
import com.example.waa_final_project.Reposetory.OfferRepo;
import com.example.waa_final_project.Service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {
    @Autowired
    OfferRepo   offerRepo;
    @Override
    public void sendOffer(Offer offer) {
        offerRepo.save(offer);
    }

    @Override
    public void updateOfferStatus(long id, String status) {
        Offer offer = offerRepo.findById(id).orElse(null);
        if (offer != null) {
            offer.setStatus(status);
            offerRepo.save(offer);
        }
    }

}
