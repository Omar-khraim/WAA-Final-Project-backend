package com.example.waa_final_project.Reposetory;


import com.example.waa_final_project.Entity.Projection.UserOffer;
import com.example.waa_final_project.Entity.Projection.UserPropertiesPrice;
import com.example.waa_final_project.Entity.Users;
import com.example.waa_final_project.Entity.Projection.UserContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
    Users findAllByEmail(String email);
    Users findAllById(long id);
    Users findUsersByProperties_id(long prop_id);
    List<Users> findUsersByProperties_Address_ZipCode(int zipCode);
    List<UserContactInfo> findAllBy();
    @Query("SELECT u.name as name, SUM(p.price) as propertyPriceTotal FROM Users u JOIN u.properties p  where u.id = :userId GROUP BY u.id  ")
    UserPropertiesPrice findUserPropertyPriceTotal(long userId);
    UserOffer findUsersById(long id);

}