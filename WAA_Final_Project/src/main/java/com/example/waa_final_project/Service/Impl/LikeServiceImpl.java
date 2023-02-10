package com.example.waa_final_project.Service.Impl;

import com.example.waa_final_project.Entity.Like;
import com.example.waa_final_project.Reposetory.LikesRepo;
import com.example.waa_final_project.Reposetory.PropertyRepo;
import com.example.waa_final_project.Reposetory.UsersRepo;
import com.example.waa_final_project.Service.LikeService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class LikeServiceImpl implements LikeService {

    final private LikesRepo likesRepo;
    final private UsersRepo usersRepo;
    final private PropertyRepo propertyRepo;

    public LikeServiceImpl(LikesRepo likesRepo, UsersRepo usersRepo, PropertyRepo propertyRepo) {
        this.likesRepo = likesRepo;
        this.usersRepo = usersRepo;
        this.propertyRepo = propertyRepo;
    }


    @Override
    public void addLike(long userId, long propId) {
        if (propertyRepo.existsById(propId)
                && usersRepo.existsById(userId)) {
            Like newLike = new Like();
            newLike.setProperty(propertyRepo.findById(propId).get());
            newLike.setUsers(usersRepo.findById(userId).get());

            likesRepo.save(newLike);
        }

    }

    @Override
    public List<Like> findByUserId(long userId) {
        return likesRepo.findAllByUsersId(userId);
    }

    @Override
    public List<Like> findByPropertyId(long propertyId) {
        return likesRepo.findAllByPropertyId(propertyId);
    }

    @Override
    public void deleteLike(Like like) {
        likesRepo.delete(like);
    }
}
