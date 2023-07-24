package com.kingdoms.thekingdonsproject.Controller;

import com.kingdoms.thekingdonsproject.Model.PostDTO;
import com.kingdoms.thekingdonsproject.Model.UserDTO;
import com.kingdoms.thekingdonsproject.Service.PostService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController

public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping("/postTest")
    public void postTest(){
        PostDTO postDTO = new PostDTO();
        postDTO.setUserId(1);
        postDTO.setTitle("예시");
        postDTO.setContent("내용");
        postDTO.setCreatedTime(LocalDateTime.now());
        postDTO.setView(2);
        postDTO.setCommentView(2);
        System.out.println(postDTO);

        postService.insertPost(postDTO);

    }


    @GetMapping("/post")
    public List<PostDTO> postList(){
        List<PostDTO> postList = postService.selectAllPost();
        System.out.println(postList);
        return postList;
    }

    @PostMapping("/post")
    // json의 body를 받음
    public void createPost(@RequestBody HashMap<String, Object> map) {
        Integer userId = Integer.parseInt(map.get("user_id").toString());
        String title = map.get("title").toString();
        String content = map.get("content").toString();

        PostDTO newPostDTO = new PostDTO();
        newPostDTO.setUserId(userId);
        newPostDTO.setTitle(title);
        newPostDTO.setContent(content);
        newPostDTO.setView(0);
        newPostDTO.setCreatedTime(LocalDateTime.now());

        System.out.println(newPostDTO.getContent());

        postService.insertPost(newPostDTO);
    }

    @GetMapping("/post/{postId}")
    public PostDTO postOne(@PathVariable Integer postId) {
        PostDTO one = postService.selectPost(postId);
        System.out.println(one);
        return one;
    }
}
