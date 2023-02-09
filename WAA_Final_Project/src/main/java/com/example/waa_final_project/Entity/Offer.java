package com.example.waa_final_project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String offerType;
    String offerDescription;
    String status;
    String agentEmail;
    double offerAmount;
    double creditScore;

    @OneToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    Users user;
    @ManyToOne
    @JoinColumn(name = "property_id")
    @JsonIgnore
    Property property;

}
