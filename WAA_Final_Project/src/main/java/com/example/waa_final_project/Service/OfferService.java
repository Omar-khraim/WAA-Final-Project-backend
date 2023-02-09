package com.example.waa_final_project.Service;

import com.example.waa_final_project.Entity.Offer;

import java.util.List;

public interface OfferService {
    public void sendOffer(long prop_id,long user_id,Offer offer);
    public void updateOfferStatus(long id, String status);
    public List<Offer> findAllByUser_Id(long id);
    public List<Offer> findAllByProperty_Owner_Id(long id);
    public void deleteOffer(long id);
    Offer findAllById(long id);


}
