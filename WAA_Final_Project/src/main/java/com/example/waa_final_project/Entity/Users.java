package com.example.waa_final_project.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

//@JsonIgnoreProperties({"properties"})
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;
    private String username;
    @JsonIgnore
    private String password;
    private String phoneNumber;


    @OneToOne
    @JsonManagedReference("usersRoleReference")
//    @JsonIgnore
    private Role role;


    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @JsonBackReference("usersPropertyReference")
//    @JsonIgnore
    private List<Property> properties;

    @OneToMany(mappedBy = "users")
    @JsonBackReference("usersLikeReference")
//    @JsonIgnore
    List<Like> likes;

    @OneToMany(mappedBy = "user")
    @JsonBackReference("offerUserReference")
//    @JoinColumn(name = "customer_id")
    List<Offer> offers;

}
