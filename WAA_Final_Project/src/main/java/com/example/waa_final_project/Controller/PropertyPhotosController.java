package com.example.waa_final_project.Controller;


import com.example.waa_final_project.Dto.PropertyPhotoDto;
import com.example.waa_final_project.Service.Impl.PropertyPhotoServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/photo")
public class PropertyPhotosController {

    private final PropertyPhotoServiceImpl photoService;

    public PropertyPhotosController(PropertyPhotoServiceImpl photoService) {
        this.photoService = photoService;
    }

    @PostMapping
    void addPhoto(@RequestParam("image") MultipartFile image) throws IOException {
        photoService.addPhoto(image);
    }
}
