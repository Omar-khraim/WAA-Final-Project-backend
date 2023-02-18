package com.example.waa_final_project.Service.Impl;

import com.example.waa_final_project.Entity.MongoEntity.Comment;
import com.example.waa_final_project.Reposetory.CommentRepo;
import com.example.waa_final_project.Service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    final private CommentRepo commentsRepo;

    public CommentServiceImpl(CommentRepo commentsRepo) {
        this.commentsRepo = commentsRepo;
    }

    @Override
    public void addComment() {
        Comment comment = new Comment();
        comment.setBody("body");
        comment.setTitle("hello");
        commentsRepo.save(comment);
    }
}
