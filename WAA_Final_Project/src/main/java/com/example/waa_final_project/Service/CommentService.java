package com.example.waa_final_project.Service;

import com.example.waa_final_project.Dto.CommentDTO;

import java.util.List;

public interface CommentService {
    void addComment(CommentDTO comment);

    void deleteById(Long id );
    void update(CommentDTO comment);

    CommentDTO getBtId(long id);

    List<CommentDTO> getByOfferId(String offerId);
}
