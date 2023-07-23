package com.kingdoms.thekingdonsproject.Model;

import lombok.Data;

@Data
public class PostDTO {
    private int postId;
    private int userId;
    private String title;
    private String content;
    private int createdTime;
    private int view;
    private int commentView;
}




