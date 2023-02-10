package com.example.waa_final_project.Service;


import com.example.waa_final_project.Dto.AddPropertyDto;
import com.example.waa_final_project.Dto.PropertyDto;
import com.example.waa_final_project.Entity.Property;

import java.util.List;

public interface PropertyService {

    PropertyDto findById(long id);

    List<PropertyDto> findAll();

    void deleteById(long id);

    void addProperty(long owner_id,AddPropertyDto property);

    void update(PropertyDto property);
    List<PropertyDto> filter(Integer numOfRooms, Integer numberOfBathrooms, String zip, String city, String priceRange,String propertyType);

    List<Property> findUserLikedProperties(long userId);

    void updatePropertyStatus (long id,int status);

    List<PropertyDto> findAllByOwner_Id(long id);

    String getOwnerEmailByPropertyId(long prop_id);


}
