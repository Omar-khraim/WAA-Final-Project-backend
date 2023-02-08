package com.example.waa_final_project.Service;

import com.example.waa_final_project.Entity.Offer;

public interface OfferService {
    public void sendOffer(Offer offer);
    public void updateOfferStatus(long id, String status);
}
