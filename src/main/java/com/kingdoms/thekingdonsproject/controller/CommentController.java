package com.kingdoms.thekingdonsproject.controller;

import com.kingdoms.thekingdonsproject.model.CommentDTO;
import com.kingdoms.thekingdonsproject.model.UserDTO;
import com.kingdoms.thekingdonsproject.service.CommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping("/comment/{postId}")
    public List<CommentDTO> comment(@PathVariable Integer postId){
        System.out.println(postId);
        //CommentDTO commentDTO = new CommentDTO();
        //return commentDTO;
        return commentService.getComments(postId);
    }

}
