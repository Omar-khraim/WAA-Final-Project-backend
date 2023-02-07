package com.example.waa_final_project.Dto;

import com.example.waa_final_project.Entity.Address;
import com.example.waa_final_project.Entity.PropertyPhotos;
import com.example.waa_final_project.Entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDto {

    private long id;
    private int status;
    String details;
    String address;
    double price;

    private List<PropertyPhotos> photos;


}