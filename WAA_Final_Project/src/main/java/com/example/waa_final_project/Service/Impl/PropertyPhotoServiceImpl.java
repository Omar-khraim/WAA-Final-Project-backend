package com.example.waa_final_project.Service.Impl;

import com.example.waa_final_project.Dto.PropertyPhotoDto;
import com.example.waa_final_project.Entity.PropertyPhotos;
import com.example.waa_final_project.Reposetory.PropertyPhotosRepo;
import com.example.waa_final_project.Service.PropertyPhotosService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class PropertyPhotoServiceImpl implements PropertyPhotosService {

private final PropertyPhotosRepo photosRepo;
private final ModelMapper modelMapper;

    public PropertyPhotoServiceImpl(PropertyPhotosRepo photosRepo, ModelMapper modelMapper) {
        this.photosRepo = photosRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addPhoto(PropertyPhotoDto photoDto) {

        System.out.println(photoDto);
//        photosRepo.save(modelMapper.map(photoDto, PropertyPhotos.class));
    }
}
