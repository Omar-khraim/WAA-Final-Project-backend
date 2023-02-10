package com.example.waa_final_project.Controller;


import com.example.waa_final_project.Dto.AddLikeDto;
import com.example.waa_final_project.Entity.Like;
import com.example.waa_final_project.Service.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/likes")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public void addLike(@RequestBody AddLikeDto likeData) {
        likeService.addLike(likeData.getUserId(), likeData.getPropertyId());
    }
    @DeleteMapping
    public void removeLike(@RequestBody Like likeData) {
        likeService.deleteLike(likeData);
    }

    @GetMapping
    public List<Like> findAll(@RequestParam(required = false) Optional<Long> userId,
                              @RequestParam(required = false) Optional<Long> propId) {
        if (userId.isPresent() && userId.get() != 0)
            return likeService.findByUserId(userId.get());
        else if (propId.isPresent() && propId.get() != 0)
            return likeService.findByPropertyId(propId.get());
        return null;
    }

}
