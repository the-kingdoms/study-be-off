package com.kingdoms.thekingdonsproject.controller;

import com.kingdoms.thekingdonsproject.model.UserDTO;
import com.kingdoms.thekingdonsproject.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {
    private UserService userService;

    public SignupController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/signup")
    public void signup(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("yc");
        userDTO.setEmail("cyc8649@Gmail.com");
        userDTO.setPassword("1234");
        System.out.println("userDTO = " + userDTO);
        userService.insertUser(userDTO);
    }
}
