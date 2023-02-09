package com.example.waa_final_project.Service.Impl;

import com.example.waa_final_project.Entity.Offer;
import com.example.waa_final_project.Reposetory.OfferRepo;
import com.example.waa_final_project.Service.OfferService;
import com.example.waa_final_project.Util.Enum.OfferStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.waa_final_project.Reposetory.PropertyRepo;
import com.example.waa_final_project.Reposetory.UsersRepo;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    @Autowired
    OfferRepo offerRepo;
    @Autowired
    UsersRepo usersRepo;

    @Autowired
    PropertyRepo propertyRepo;

    @Autowired
    PropertyServiceImpl propertyService;

    @Override
    public void sendOffer(long prop_id, long user_id, Offer offer) {
        var user = usersRepo.findAllById(user_id);
        if (user != null) {
            var prop = propertyRepo.findAllById(prop_id);
            if (prop != null) {
                offer.setUser(user);
                offer.setProperty(prop);
                offerRepo.save(offer);
            }
        } else
            System.out.println("There is no user");
    }

    @Override
    public void updateOfferStatus(long id, String status) {
        Offer offer = offerRepo.findById(id).orElse(null);
        if (offer != null) {
            offer.setStatus(OfferStatus.valueOf(status).getValue());
            propertyService.updatePropertyStatus(offer.getProperty().getId(), OfferStatus.valueOf(status).getValue() == 1 ? 2 : 1);
            offerRepo.save(offer);
        }
    }

    @Override
    public List<Offer> findAllByUser_Id(long id) {
        return offerRepo.findAllByUser_Id(id);
    }

    @Override
    public List<Offer> findAllByProperty_Owner_Id(long id) {
        return offerRepo.findAllByProperty_Owner_Id(id);

    }

    @Override
    public void deleteOffer(long id) {
        offerRepo.deleteById(id);
    }

    @Override
    public Offer findAllById(long id) {
        return offerRepo.findAllById(id);
    }


}
