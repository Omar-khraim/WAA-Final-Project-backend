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
    public void updateAcceptedOfferStatus(long id, String status) {
        Offer offer = offerRepo.findById(id).orElse(null);
        if (offer != null) {
            offer.setStatus(OfferStatus.valueOf(status).getValue());
            var prop = propertyRepo.findAllById(offer.getProperty().getId());
            if (prop.getStatus() == 1 || prop.getStatus() == 2)
                propertyService.updatePropertyStatus(offer.getProperty().getId(), 2);
            offerRepo.save(offer);
        }
    }

    @Override
    public void updateRejectedOfferStatus(long id, String status) {
        Offer offer = offerRepo.findById(id).orElse(null);
        if (offer != null) {
            offer.setStatus(OfferStatus.valueOf(status).getValue());
            offerRepo.save(offer);
        }
    }

    @Override
    public void updateContingentOfferStatus(long id, String status) {
        Offer offer = offerRepo.findById(id).orElse(null);
        if (offer != null) {
            var prop = propertyRepo.findAllById(offer.getProperty().getId());
            if (prop.getStatus() == 2) {
                var otherOffers = offerRepo.findOffersByIdIsNot(id);
                otherOffers.forEach(o -> {
                    o.setStatus(2);
                    offerRepo.save(o);
                });
                offer.setStatus(OfferStatus.valueOf(status).getValue());
                propertyService.updatePropertyStatus(offer.getProperty().getId(), 3);
                offerRepo.save(offer);
            }
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
        Offer offer = offerRepo.findById(id).orElse(null);
        if (offer != null) {
            var prop = propertyRepo.findAllById(offer.getProperty().getId());
            if (prop.getStatus() == 1) {
                offerRepo.deleteById(id);
            } else if (prop.getStatus() == 2) {
                var approvedOffers = offerRepo.findOffersByStatus(1);
                if (approvedOffers.size() == 1) {
                    if (approvedOffers.get(0).getId() == id) {
                        propertyService.updatePropertyStatus(offer.getProperty().getId(), 1);
                        offerRepo.deleteById(id);
                    } else if (approvedOffers.size() > 1) {
                        offerRepo.deleteById(id);
                    }
                } else {
                    offerRepo.deleteById(id);
                }
            }
        }
    }

    @Override
    public Offer findAllById(long id) {
        return offerRepo.findAllById(id);
    }

    @Override
    public List<Offer> findOffersByUser_IdAndProperty_Id(long user_id, long prop_id) {
        return offerRepo.findOffersByUser_IdAndProperty_Id(user_id,prop_id);
    }

    @Override
    public List<Offer> findOffersByProperty_Id(long prop_id) {
        return offerRepo.findOffersByProperty_Id(prop_id);
    }


}
