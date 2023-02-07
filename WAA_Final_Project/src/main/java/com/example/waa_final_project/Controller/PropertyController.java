package com.example.waa_final_project.Controller;


import com.example.waa_final_project.Dto.PropertyDto;
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
}
