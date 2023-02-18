package com.example.waa_final_project.Reposetory;

import com.example.waa_final_project.Entity.MongoEntity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepo extends MongoRepository<Comment, Long> {
}
