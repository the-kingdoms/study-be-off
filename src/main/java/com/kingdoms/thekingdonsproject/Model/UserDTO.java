package com.kingdoms.thekingdonsproject.Model;

import lombok.Data;

@Data
public class UserDTO {
    private int userId;
    private String userName;
    private String email;
    private String password;
}

