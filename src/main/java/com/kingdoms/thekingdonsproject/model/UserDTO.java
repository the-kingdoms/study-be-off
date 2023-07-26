package com.kingdoms.thekingdonsproject.model;

import lombok.Data;

@Data
public class UserDTO {
    private int userId;
    private String userName;
    private String email;
    private String password;
}
