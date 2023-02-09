package com.example.waa_final_project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PropertyPhotos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

//    @Lob
//    @Column(length = 1000)
//    byte[] image;
    private String name;
    private String path;

    @ManyToOne
    Property property;


}
