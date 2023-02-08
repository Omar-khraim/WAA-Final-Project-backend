package com.example.waa_final_project.Entity;

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
    String offerDescription;
    String status;
    String agentEmail;
    @OneToOne
    @JoinColumn(name = "customer_id")
    Users   user;
    @ManyToOne
    @JoinColumn(name = "property_id")
    Property    property;

}
