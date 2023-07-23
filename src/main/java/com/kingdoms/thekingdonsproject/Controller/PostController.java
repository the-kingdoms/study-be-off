package com.kingdoms.thekingdonsproject.Controller;

import com.kingdoms.thekingdonsproject.Model.PostDTO;
import com.kingdoms.thekingdonsproject.Model.UserDTO;
import com.kingdoms.thekingdonsproject.Service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping("/test2")
    public void test2(){
        PostDTO postDTO = new PostDTO();
        postDTO.setUserId(1);
        postDTO.setTitle("예시");
        postDTO.setContent("내용");
//        postDTO.setCreatedTime(11);
        postDTO.setView(2);
        postDTO.setCommentView(2);
        System.out.println(postDTO);

        postService.insertPost(postDTO);

    }

    @GetMapping("/postselectone/{postId}")
    public void test3(@PathVariable Integer postId) {
        PostDTO p = postService.selectPost(postId);
        System.out.println(p);
    }

    @GetMapping("/postselectall")
    public void test3(){
        List<PostDTO> a = postService.selectAllPost();
        System.out.println(a);
    }

}
