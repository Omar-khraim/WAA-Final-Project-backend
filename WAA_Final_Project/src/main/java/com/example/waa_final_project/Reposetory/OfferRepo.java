package com.example.waa_final_project.Reposetory;

import com.example.waa_final_project.Entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepo extends JpaRepository<Offer, Long> {

    List<Offer> findAllByUser_Id(long id);

    List<Offer> findAllByProperty_Owner_Id(long id);

    Offer findAllById(long id);

    List<Offer> findOffersByIdIsNot(long id);

    List<Offer> findOffersByStatus(int status);
    List<Offer> findOffersByUser_IdAndProperty_Id(long user_id,long prop_id);
    List<Offer> findOffersByProperty_Id(long prop_id);
    @Query("SELECT MAX(id) from Offer")
    Long findMaxId();
}
