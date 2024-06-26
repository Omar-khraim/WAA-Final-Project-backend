package com.example.waa_final_project.Entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.index.Indexed;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Indexed
    long id;

    String offerType;
    String offerDescription;
    int status;
    String agentEmail;
    double offerAmount;
    double creditScore;

    @ManyToOne(cascade = CascadeType.PERSIST)
    //    @JoinColumn(name = "customer_id")
    @JsonManagedReference("offerUserReference")
    Users user;
    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "property_id")
    @JsonManagedReference("offerPropReference")
    Property property;

}
