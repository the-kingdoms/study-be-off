package com.kingdoms.thekingdonsproject.controller;

import com.kingdoms.thekingdonsproject.model.CommentDTO;
import com.kingdoms.thekingdonsproject.model.UserDTO;
import com.kingdoms.thekingdonsproject.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@RestController
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping("/comment/{postId}")
    public List<CommentDTO> comment(@PathVariable Integer postId){
        //CommentDTO commentDTO = new CommentDTO();
        //return commentDTO;
        return commentService.getComments(postId);
    }
    @PostMapping("/comment/{postId}")
    public void insertComment(@PathVariable Integer postId,
      @RequestBody HashMap<String, Object> map){
        CommentDTO commentDTO = new CommentDTO();

        Integer id = Integer.parseInt(map.get("user_id").toString());
        String content = map.get("content").toString();
        String date = LocalDateTime.now().toString();

        commentDTO.setUserId(id);
        commentDTO.setContent(content);
        commentDTO.setPostId(postId);
        commentDTO.setCreateDate(date);

        commentService.insertComment(commentDTO);
    }

}
