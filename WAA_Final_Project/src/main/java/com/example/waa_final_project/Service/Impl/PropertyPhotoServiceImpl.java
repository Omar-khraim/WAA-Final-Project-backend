package com.example.waa_final_project.Service.Impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.example.waa_final_project.Entity.PropertyPhotos;
import com.example.waa_final_project.Reposetory.PropertyPhotosRepo;
import com.example.waa_final_project.Reposetory.PropertyRepo;
import com.example.waa_final_project.Service.PropertyPhotosService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;


@Service
@Transactional
public class PropertyPhotoServiceImpl implements PropertyPhotosService {

    private final PropertyPhotosRepo photosRepo;
    private final ModelMapper modelMapper;
    private final AmazonS3 amazonS3;
    private final PropertyRepo propertyRepo;

    public PropertyPhotoServiceImpl(PropertyPhotosRepo photosRepo, ModelMapper modelMapper, AmazonS3 amazonS3, PropertyRepo propertyRepo) {
        this.photosRepo = photosRepo;
        this.modelMapper = modelMapper;
        this.amazonS3 = amazonS3;
        this.propertyRepo = propertyRepo;
    }

    @Override
    public void addPhoto(long propId, MultipartFile image) throws IOException {
        String imageName = image.getOriginalFilename();
        String imageType = image.getContentType();
        byte[] imageBytes = image.getBytes();

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(imageType);
        objectMetadata.setContentLength(imageBytes.length);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);

        amazonS3.putObject("waafinal", imageName, inputStream, objectMetadata);

        PropertyPhotos newImage = new PropertyPhotos();
        newImage.setName(imageName);
        newImage.setProperty(propertyRepo.findById(propId).get());
        newImage.setPath("https://s3.amazonaws.com/my-s3-bucket/" + imageName);
        photosRepo.save(newImage);


    }
}
