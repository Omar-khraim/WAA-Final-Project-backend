package com.example.waa_final_project.Reposetory;

import com.example.waa_final_project.Entity.Like;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikesRepo extends JpaRepository<Like, Long> {

    List<Like> findAllByUsersId(long userId);
    List<Like> findAllByPropertyId(long propId);

}
