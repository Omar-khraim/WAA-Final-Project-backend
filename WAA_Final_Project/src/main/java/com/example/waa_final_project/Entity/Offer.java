package com.example.waa_final_project.Entity;

import com.example.waa_final_project.Util.Enum.OfferStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    int status;
    String agentEmail;
    double offerAmount;
    double creditScore;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    Users user;
    @ManyToOne
    @JoinColumn(name = "property_id")
    @JsonIgnore
    Property property;

}
