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
    @JsonBackReference("usersPropertyReference")
    Users owner;

    @OneToOne
//    @JoinColumn(name = "address_id")
    @JsonManagedReference("propertyAddressReference")
    Address address;

    @OneToMany(mappedBy = "property")
    @JsonBackReference("propertyPropertyPhotosReference")
    List<PropertyPhotos> photos;


    @OneToMany(mappedBy = "property")
    @JsonBackReference("offerPropReference")
    List<Offer> offers;


    @JsonIgnore
    @JsonBackReference("propertyLikeReference")
    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    List<Like> likes;


}
