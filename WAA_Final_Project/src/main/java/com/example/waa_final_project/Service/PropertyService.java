package com.example.waa_final_project.Service;


import com.example.waa_final_project.Dto.PropertyDto;
import com.example.waa_final_project.Entity.Property;

import java.util.List;

public interface PropertyService {

    PropertyDto findById(long id);

    List<PropertyDto> findAll();

    void deleteById(long id);

    void addProperty(PropertyDto property);

    void update(PropertyDto property);
    List<PropertyDto> filter(Integer numOfRooms, Integer numberOfBathrooms, String zip, String city, Double price);

    List<Property> findUserLikedProperties(long userId);
}
