package com.example.waa_final_project.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String city;
    String state;
    String street;
    int zipCode;

    @OneToOne(mappedBy = "address")
    @JsonBackReference("propertyAddressReference")
    Property property;
}
