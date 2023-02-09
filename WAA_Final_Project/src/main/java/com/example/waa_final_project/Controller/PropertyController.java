package com.example.waa_final_project.Controller;


import com.example.waa_final_project.Dto.PropertyDto;
import com.example.waa_final_project.Entity.Property;
import com.example.waa_final_project.Service.PropertyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/properties")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public List<PropertyDto> findAll(){
        return propertyService.findAll();
    }

    @GetMapping("/{id}")
    public PropertyDto findById(@PathVariable long id){
        return propertyService.findById(id);
    }

    @PostMapping
    public void addProperty(@RequestBody PropertyDto property){
        propertyService.addProperty(property);
    }


    @PutMapping
    public void editProperty(@RequestBody PropertyDto property){
        propertyService.update(property);
    }

    @GetMapping("/filter")
    public List<PropertyDto> filter(@RequestParam(value = "rooms", required = false) Integer rooms,
                                    @RequestParam(value = "bathrooms", required = false) Integer bathrooms,
                                    @RequestParam(value = "zip", required = false) String zip,
                                    @RequestParam(value = "city", required = false) String city,
                                    @RequestParam(value = "price", required = false) Double price){
        return propertyService.filter(rooms, bathrooms, zip, city, price);
    }

    @GetMapping("/likes/{userId}")
    public List<Property> findUserLikedPropertyId(@PathVariable long userId){
        return propertyService.findUserLikedProperties(userId);
    }
}
