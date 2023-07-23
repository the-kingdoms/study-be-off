package com.kingdoms.thekingdonsproject.controller;

import com.kingdoms.thekingdonsproject.model.UserDTO;
import com.kingdoms.thekingdonsproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/test")
    public void method(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("yc");
        userDTO.setEmail("cyc8649@Gmail.com");
        userDTO.setPassword("1234");
        System.out.println("userDTO = " + userDTO);
        userService.insertUser(userDTO);
    }
}
