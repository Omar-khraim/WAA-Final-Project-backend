package com.example.waa_final_project.Service.Impl;

import com.example.waa_final_project.Dto.PropertyDto;
import com.example.waa_final_project.Entity.Property;
import com.example.waa_final_project.Reposetory.PropertyRepo;
import com.example.waa_final_project.Service.PropertyService;
import com.example.waa_final_project.Util.Helper.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepo propertyRepo;

    private final ModelMapper modelMapper;

    private final ListMapper<Property, PropertyDto> listMapperToDto;

    public PropertyServiceImpl(PropertyRepo propertyRepo, ModelMapper modelMapper, ListMapper<Property, PropertyDto> listMapper) {
        this.propertyRepo = propertyRepo;
        this.modelMapper = modelMapper;
        this.listMapperToDto = listMapper;
    }


    @Override
    public PropertyDto findById(long id) {
        var p = propertyRepo.findAllById(id);
        return CreateDto(p);
    }

    public PropertyDto CreateDto(Property p) {
        PropertyDto dto = new PropertyDto();
        dto.setAddress(p.getAddress().getStreet() + ", " + p.getAddress().getCity() + ", " + p.getAddress().getState() + " " + p.getAddress().getZipCode());
        dto.setDetails(p.getRoomNum() + " bed " + p.getBathroomNum() + " bath " + p.getAreaInSquareFeet() + " sqft");
        dto.setStatus(p.getStatus());
        dto.setId(p.getId());
        dto.setPhotos(p.getPhotos());
        dto.setPrice(p.getPrice());
        return dto;
    }

    @Override
    public List<PropertyDto> findAll() {
        var props = propertyRepo.findAll();
        List<PropertyDto> propertyDtos = new ArrayList<>();
        props.forEach(p -> {
            propertyDtos.add(CreateDto(p));
        });
        return propertyDtos;
    }

    @Override
    public void deleteById(long id) {
        propertyRepo.deleteById(id);
    }

    @Override
    public void addProperty(PropertyDto propertyDto) {
        propertyRepo.save(modelMapper.map(propertyDto, Property.class));
    }

    @Override
    public void update(PropertyDto propertyDto) {
        propertyRepo.save(modelMapper.map(propertyDto, Property.class));
    }
}
