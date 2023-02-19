package com.example.waa_final_project.Entity.MongoEntity;

import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertCallback;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveCallback;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class LongIdGenerator implements BeforeConvertCallback<Comment>, BeforeSaveCallback<Comment> {

    private final AtomicLong counter = new AtomicLong(1);
    @Override
    public Comment onBeforeConvert(Comment comment, String s) {
        if (comment.getCommentId() == null) {
            comment.setCommentId(counter.getAndIncrement());
        }
        return comment;
    }


    @Override
    public Comment onBeforeSave(Comment comment, Document document, String s) {
        if (comment.getCommentId() == null) {
            comment.setCommentId(counter.getAndIncrement());
        }
        return comment;
    }
}
