package com.example.waa_final_project.Entity;

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

@JsonIgnoreProperties({"properties"})
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;
    private String username;
    private String password;
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private Role role;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<Property> properties;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    List<Like> likes;
}
