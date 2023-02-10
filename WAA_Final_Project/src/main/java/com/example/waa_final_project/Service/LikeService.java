package com.example.waa_final_project.Service;

import com.example.waa_final_project.Entity.Like;

import java.util.List;

public interface LikeService {

    void addLike(long userId, long propId);

    List<Like> findByUserId(long userId);

    List<Like> findByPropertyId(long propertyId);
    void deleteLike(Like like);


}
