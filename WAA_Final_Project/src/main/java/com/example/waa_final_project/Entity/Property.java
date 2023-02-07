package com.example.waa_final_project.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    int roomNum;
    int bathroomNum;
    int status;
    int areaInSquareFeet;

    @ManyToOne
    @JsonBackReference
    Users owner;

    @OneToOne
    @JoinColumn(name = "address_id")
    Address address;

    @OneToMany(mappedBy = "property")
    @JsonBackReference
    List<PropertyPhotos> photos;


}
