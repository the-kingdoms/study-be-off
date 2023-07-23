package com.kingdoms.thekingdonsproject.Model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDTO {
    private int postId;
    private int userId;
    private String title;
    private String content;
    private LocalDateTime createdTime;
    private int view;
    private int commentView;
}




