package com.example.waa_final_project.Controller;


import com.example.waa_final_project.Dto.PropertyPhotoDto;
import com.example.waa_final_project.Service.Impl.PropertyPhotoServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/photo")
public class PropertyPhotosController {

    private final PropertyPhotoServiceImpl photoService;

    public PropertyPhotosController(PropertyPhotoServiceImpl photoService) {
        this.photoService = photoService;
    }

    @PostMapping
    void addPhoto(@RequestBody PropertyPhotoDto photoDto){
        photoService.addPhoto(photoDto);
    }
}
