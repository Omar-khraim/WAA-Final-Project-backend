package com.example.waa_final_project.Reposetory;


import com.example.waa_final_project.Entity.Property;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepo extends JpaRepository<Property, Long> {

    @Override
    List<Property> findAll();

    Property findAllById(long id);

    List<Property> findAllByLikes_Users_Id(long id);

}
