package com.example.waa_final_project.Controller;


import com.example.waa_final_project.Dto.AddPropertyDto;
import com.example.waa_final_project.Dto.PropertyDto;
import com.example.waa_final_project.Entity.Property;
import com.example.waa_final_project.Service.PropertyService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/properties")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public List<PropertyDto> findAll() {
        return propertyService.findAll();
    }

    @GetMapping("/{id}")
    public PropertyDto findById(@PathVariable long id) {
        return propertyService.findById(id);
    }

//    @PostMapping
//    public void addProperty(@RequestBody AddPropertyDto property) {
//        propertyService.addProperty(property);
//    }


    @PutMapping
    public void editProperty(@RequestBody PropertyDto property) {
        propertyService.update(property);
    }

    @GetMapping("/filter")
    public List<PropertyDto> filter(@RequestParam(value = "rooms", required = false) Integer rooms,
                                    @RequestParam(value = "bathrooms", required = false) Integer bathrooms,
                                    @RequestParam(value = "zip", required = false) String zip,
                                    @RequestParam(value = "propertyType", required = false) String propertyType,
                                    @RequestParam(value = "city", required = false) String city,
                                    @RequestParam(value = "priceRange", required = false) String priceRange) {
        return propertyService.filter(rooms, bathrooms, zip, city, priceRange,propertyType);
    }

    @GetMapping("/likes/{userId}")
    public List<Property> findUserLikedPropertyId(@PathVariable long userId) {
        return propertyService.findUserLikedProperties(userId);
    }

    @PutMapping("{id}/contingent")
    public void makePropertyContingent(@PathVariable long id) {
        propertyService.updatePropertyStatus(id, 3);
    }

    @PutMapping("{id}/sold")
    public void makePropertySold(@PathVariable long id) {
        propertyService.updatePropertyStatus(id, 4);
    }
    @GetMapping("{id}/ownerEmail")
    public String getOwnerEmail(@PathVariable long id) {
        return  propertyService.getOwnerEmailByPropertyId(id);
    }

    @GetMapping("/pageination")
    List<Property> getAllSortedByOwnerId(@RequestParam int pageNumber,@RequestParam int size){
        Pageable pageableObj =  PageRequest.of(pageNumber, size);
        return propertyService.findAllOrderByOwnerId(pageableObj);
    }
}
