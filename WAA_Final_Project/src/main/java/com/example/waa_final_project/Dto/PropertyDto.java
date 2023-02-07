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
    private int roomNum;
    private int bathroomNum;
    private int status;
    private int areaInSquareFeet;

    private Users owner;
    private Address address;
    private List<PropertyPhotos> photos;


}
