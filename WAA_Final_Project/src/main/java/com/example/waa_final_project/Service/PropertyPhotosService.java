package com.example.waa_final_project.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PropertyPhotosService {

    void addPhoto(long propId, MultipartFile photoDto) throws IOException;
}
