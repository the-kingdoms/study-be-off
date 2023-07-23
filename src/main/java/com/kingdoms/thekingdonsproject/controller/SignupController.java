package com.kingdoms.thekingdonsproject.controller;

import com.kingdoms.thekingdonsproject.model.UserDTO;
import com.kingdoms.thekingdonsproject.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class SignupController {
    private UserService userService;

    public SignupController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/signup")
    public void signup (@RequestBody HashMap<String, Object> map){
        UserDTO userDTO = new UserDTO();

        String username = map.get("username").toString();
        String email = map.get("email").toString();
        String password = map.get("password").toString();

        userDTO.setUserName(username);
        userDTO.setEmail(email);
        userDTO.setPassword(password);
        userService.insertUser(userDTO);
        //email중복?
    }
}
