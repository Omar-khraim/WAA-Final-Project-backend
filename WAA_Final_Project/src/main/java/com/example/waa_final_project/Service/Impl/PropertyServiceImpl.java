package com.example.waa_final_project.Service.Impl;

import com.example.waa_final_project.Dto.AddPropertyDto;
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
        dto.setPropertyType(p.getPropertyType());
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
    public void addProperty(long owner_id, AddPropertyDto propertyDto) {
        var owner = usersRepo.findAllById(owner_id);
        if (owner != null) {
            var prop = modelMapper.map(propertyDto, Property.class);
            Address address = new Address();
            address.setCity(propertyDto.getCity());
            address.setStreet(propertyDto.getStreet());
            address.setZipCode(propertyDto.getZipCode());
            address.setState(propertyDto.getState());
            prop.setAddress(address);
            prop.setOwner(owner);
            propertyRepo.save(prop);
        }
    }

    @Override
    public void update(PropertyDto propertyDto) {
        propertyRepo.save(modelMapper.map(propertyDto, Property.class));
    }

    @Override
    public List<PropertyDto> filter(Integer numOfRooms, Integer numberOfBathrooms, String zip, String city, String priceRange, String propertyType) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Property> cq = cb.createQuery(Property.class);
        Root<Property> root = cq.from(Property.class);
        Join<Property, Address> addressJoin = root.join("address");
        int lowerBound = 0;
        int upperBound = 0;
        if (!priceRange.isEmpty()) {
            if (priceRange.contains("+")) {
                lowerBound = 200000;
                upperBound = Integer.MAX_VALUE;
            } else {
                String[] range = priceRange.split("-");
                lowerBound = Integer.parseInt(range[0]);
                upperBound = Integer.parseInt(range[1]);
            }
        }
        List<Predicate> searchCriteria = new ArrayList<>();

        if (numOfRooms != null)
            searchCriteria.add(cb.equal(root.get("roomNum"), numOfRooms));
        if (numberOfBathrooms != null)
            searchCriteria.add(cb.equal(root.get("bathroomNum"), numberOfBathrooms));
        if (zip != null && !zip.isEmpty())
            searchCriteria.add(cb.equal(addressJoin.get("zip"), zip));
        if (city != null && !city.isEmpty())
            searchCriteria.add(cb.equal(addressJoin.get("city"), city));
        if (!priceRange.isEmpty())
            searchCriteria.add(cb.between(root.get("price"), lowerBound, upperBound));
        if (!propertyType.isEmpty())
            searchCriteria.add(cb.like(root.get("propertyType"), "%" + propertyType + "%"));
        cq.select(root).where(cb.and(searchCriteria.toArray(new Predicate[0])));

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
