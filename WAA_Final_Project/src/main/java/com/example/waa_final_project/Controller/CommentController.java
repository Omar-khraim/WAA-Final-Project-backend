package com.example.waa_final_project.Controller;


import com.example.waa_final_project.Dto.CommentDTO;
import com.example.waa_final_project.Service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    final private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public void addComment(@RequestBody CommentDTO comment){
        commentService.addComment(comment);
    }

    @GetMapping("/{commentId}")
    CommentDTO getById(@PathVariable long commentId){
        return commentService.getBtId(commentId);
    }

    @GetMapping("/offer/{offerId}")
    List<CommentDTO> getByOfferId(@PathVariable String offerId){
        return commentService.getByOfferId(offerId);
    }

    @PutMapping
    void update(CommentDTO comment){
        commentService.update(comment);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable long id){
        commentService.deleteById(id);
    }
}
