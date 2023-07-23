package com.kingdoms.thekingdonsproject.model;

import lombok.Data;

@Data
public class CommentDTO {
    private int userId;
    private String content;
    private String createDate;
    private int postId;
    private int commentId;
}
