package com.example.waa_final_project.Dto;

import com.example.waa_final_project.Entity.Address;
import com.example.waa_final_project.Entity.Like;
import com.example.waa_final_project.Entity.Offer;
import com.example.waa_final_project.Entity.PropertyPhotos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPropertyDto {
    String propertyType;
    String city;
    String state;
    String street;
    int areaInSquareFeet;
    int roomNum;
    int bathroomNum;
    int zipCode;
    private int status;
    double price;
}
