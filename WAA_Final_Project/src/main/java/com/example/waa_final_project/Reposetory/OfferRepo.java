package com.example.waa_final_project.Reposetory;

import com.example.waa_final_project.Entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepo extends JpaRepository<Offer, Long> {

    List<Offer> findAllByUser_Id(long id);
    List<Offer> findAllByProperty_Owner_Id(long id);

    Offer findAllById(long id);



}
