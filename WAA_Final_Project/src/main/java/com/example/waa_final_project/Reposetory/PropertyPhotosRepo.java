package com.example.waa_final_project.Reposetory;


import com.example.waa_final_project.Entity.PropertyPhotos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyPhotosRepo  extends JpaRepository<PropertyPhotos, Long> {

}
