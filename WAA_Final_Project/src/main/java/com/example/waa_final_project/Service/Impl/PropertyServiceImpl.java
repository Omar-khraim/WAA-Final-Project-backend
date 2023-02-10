package com.example.waa_final_project.Service.Impl;

import com.example.waa_final_project.Dto.PropertyDto;
import com.example.waa_final_project.Entity.Address;
import com.example.waa_final_project.Entity.Property;
import com.example.waa_final_project.Reposetory.PropertyRepo;
import com.example.waa_final_project.Reposetory.UsersRepo;
import com.example.waa_final_project.Service.PropertyService;
import com.example.waa_final_project.Util.Helper.ListMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    EntityManager entityManager;
    private final PropertyRepo propertyRepo;

    private final UsersRepo usersRepo;

    private final ModelMapper modelMapper;

    private final ListMapper<Property, PropertyDto> listMapperToDto;

    public PropertyServiceImpl(PropertyRepo propertyRepo, UsersRepo usersRepo, ModelMapper modelMapper, ListMapper<Property, PropertyDto> listMapper) {
        this.propertyRepo = propertyRepo;
        this.usersRepo = usersRepo;
        this.modelMapper = modelMapper;
        this.listMapperToDto = listMapper;
    }


    @Override
    public PropertyDto findById(long id) {
        var p = propertyRepo.findAllById(id);
        return CreateDto(p);
    }

    public PropertyDto CreateDto(Property p) {
        StringBuilder sb = new StringBuilder();

        PropertyDto dto = new PropertyDto();
        String address = sb.append(p.getAddress().getStreet() + ", " + p.getAddress().getCity() + ", " + p.getAddress().getState() + " " + p.getAddress().getZipCode()).toString();
        dto.setAddress(address);
        sb = new StringBuilder();
        String details = sb.append(p.getRoomNum() + " bed " + p.getBathroomNum() + " bath " + p.getAreaInSquareFeet() + " sqft").toString();
        dto.setDetails(details);
        dto.setStatus(p.getStatus());
        dto.setId(p.getId());
        dto.setPhotos(p.getPhotos());
        dto.setPrice(p.getPrice());
        dto.setOffers(p.getOffers());
        dto.setLikes(p.getLikes());
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

    @Override
    public List<PropertyDto> filter(Integer numOfRooms, Integer numberOfBathrooms, String zip, String city, Double price) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Property> cq = cb.createQuery(Property.class);
        Root<Property> root = cq.from(Property.class);
        Join<Property, Address> addressJoin = root.join("address");

        List<Predicate> searchCriteria = new ArrayList<>();

        if (numOfRooms != null)
            searchCriteria.add(cb.equal(root.get("roomNum"), numOfRooms.intValue()));
        if (numberOfBathrooms != null)
            searchCriteria.add(cb.equal(root.get("bathroomNum"), numberOfBathrooms.intValue()));
        if (zip != null && !zip.isEmpty())
            searchCriteria.add(cb.equal(addressJoin.get("zip"), zip));
        if (city != null && !city.isEmpty())
            searchCriteria.add(cb.equal(addressJoin.get("city"), city));
        if (price != null)
            searchCriteria.add(cb.equal(root.get("price"), price));
        cq.select(root).where(cb.and(searchCriteria.toArray(new Predicate[searchCriteria.size()])));

        var props = entityManager.createQuery(cq).getResultList();
        List<PropertyDto> propertyDtos = new ArrayList<>();
        props.forEach(p -> {
            propertyDtos.add(CreateDto(p));
        });
        return propertyDtos;
    }

    @Override
    public List<Property> findUserLikedProperties(long userId) {
        return propertyRepo.findAllByLikes_Users_Id(userId);
    }

    @Override
    public void updatePropertyStatus(long id, int status) {
        var prop = propertyRepo.findAllById(id);
        if (prop != null) {
            prop.setStatus(status);
            propertyRepo.save(prop);
        }
    }

    @Override
    public List<PropertyDto> findAllByOwner_Id(long id) {
        var props = propertyRepo.findAllByOwner_Id(id);
        List<PropertyDto> propertyDtos = new ArrayList<>();
        props.forEach(p -> {
            propertyDtos.add(CreateDto(p));
        });
        return propertyDtos;
    }

    @Override
    public String getOwnerEmailByPropertyId(long prop_id) {
        var user = usersRepo.findUsersByProperties_id(prop_id);
        return user.getEmail();
    }


}
