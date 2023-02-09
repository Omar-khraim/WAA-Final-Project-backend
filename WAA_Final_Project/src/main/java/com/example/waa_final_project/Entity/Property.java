package com.example.waa_final_project.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    double price;

    @ManyToOne
    @JsonBackReference
    Users owner;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
            @JsonIgnore
    Address address;

    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
    @JsonBackReference
    List<PropertyPhotos> photos;


    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
    List<Offer> offers;


    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Like> likes;


}
