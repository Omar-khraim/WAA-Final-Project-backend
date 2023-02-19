package com.example.waa_final_project.Service.Impl;

import com.example.waa_final_project.Dto.CommentDTO;
import com.example.waa_final_project.Entity.MongoEntity.Comment;
import com.example.waa_final_project.Reposetory.CommentRepo;
import com.example.waa_final_project.Service.CommentService;
import com.example.waa_final_project.Util.Helper.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    final private CommentRepo commentsRepo;
    final private ModelMapper modelMapper;
    final private ListMapper<Comment, CommentDTO> listMapper;

    public CommentServiceImpl(CommentRepo commentsRepo, MongoOperations mongoOperations, ModelMapper modelMapper, ListMapper<Comment, CommentDTO> listMapper) {
        this.commentsRepo = commentsRepo;
        this.modelMapper = modelMapper;
        this.listMapper = listMapper;
    }

    @Override
    public void addComment(CommentDTO comment) {
        commentsRepo.save(modelMapper.map(comment , Comment.class));
    }

    @Override
    public void deleteById(Long id) {
        commentsRepo.deleteByCommentId(id);
    }

    @Override
    public void update(CommentDTO comment) {
        commentsRepo.save(modelMapper.map(comment, Comment.class));
    }

    @Override
    public CommentDTO getBtId(long id) {
        return modelMapper.map(commentsRepo.findByCommentId(id), CommentDTO.class);
    }

    @Override
    public List<CommentDTO> getByOfferId(String offerId) {
//        return (List<CommentDTO>) listMapper.mapList(commentsRepo.findAllByOfferId(offerId),new CommentDTO());
        return null;
    }
}
