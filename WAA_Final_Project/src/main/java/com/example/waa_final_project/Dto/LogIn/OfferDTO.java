package com.example.waa_final_project.Dto.LogIn;

import com.example.waa_final_project.Entity.Property;
import com.example.waa_final_project.Entity.Users;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OfferDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String offerType;
    String offerDescription;
    int status;
    String agentEmail;
    double offerAmount;
    double creditScore;


}
