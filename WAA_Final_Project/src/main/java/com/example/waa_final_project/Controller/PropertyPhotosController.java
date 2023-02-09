package com.example.waa_final_project.Controller;


import com.example.waa_final_project.Service.Impl.PropertyPhotoServiceImpl;
import com.example.waa_final_project.Service.PropertyPhotosService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/photo")
public class PropertyPhotosController {

    private final PropertyPhotosService photoService;

    public PropertyPhotosController(PropertyPhotoServiceImpl photoService) {
        this.photoService = photoService;
    }

    @PostMapping
    void addPhoto(@RequestParam("image") MultipartFile image, @RequestParam long propId) throws IOException {
        photoService.addPhoto(propId, image);
    }
}
