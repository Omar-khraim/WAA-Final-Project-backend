package com.example.waa_final_project.Reposetory;

import com.example.waa_final_project.Entity.MongoEntity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepo extends MongoRepository<Comment, Long> {

    List<Comment> findAllByOfferId(long offerId);
}
