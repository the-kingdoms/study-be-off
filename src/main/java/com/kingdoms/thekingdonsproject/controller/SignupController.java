package com.kingdoms.thekingdonsproject.controller;

import com.kingdoms.thekingdonsproject.model.UserDTO;
import com.kingdoms.thekingdonsproject.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class SignupController {
    private UserService userService;

    public SignupController(UserService userService){
        this.userService = userService;
    }


    @PostMapping("/signup")
    public String signup (@RequestBody HashMap<String, Object> map) throws Exception{
        UserDTO userDTO = new UserDTO();

        String username = map.get("username").toString();
        String email = map.get("email").toString();
        String password = map.get("password").toString();

        if (userService.emailCheck(email)==1){
            throw new Exception("이미 존재하는 회원입니다.");
        }
        userDTO.setUserName(username);
        userDTO.setEmail(email);
        userDTO.setPassword(password);
        userService.insertUser(userDTO);
        return "회원 가입에 성공했습니다.";
    }
}
