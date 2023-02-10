package com.example.waa_final_project.Service;

import com.example.waa_final_project.Entity.Offer;

import java.util.List;

public interface OfferService {
    public void sendOffer(long prop_id,long user_id,Offer offer);
    public void updateAcceptedOfferStatus(long id, String status);
    public void updateRejectedOfferStatus(long id, String status);
    public void updateContingentOfferStatus(long id, String status);
    public List<Offer> findAllByUser_Id(long id);
    public List<Offer> findAllByProperty_Owner_Id(long id);
    public void deleteOffer(long id);
    Offer findAllById(long id);

    List<Offer> findOffersByUser_IdAndProperty_Id(long user_id,long prop_id);
    List<Offer> findOffersByProperty_Id(long prop_id);



}
