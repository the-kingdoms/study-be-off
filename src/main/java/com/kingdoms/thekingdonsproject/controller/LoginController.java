package com.kingdoms.thekingdonsproject.controller;

import com.kingdoms.thekingdonsproject.model.UserDTO;
import com.kingdoms.thekingdonsproject.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {
    private UserService userService;

    public LoginController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("login")
    public String Login( @RequestBody HashMap<String, Object> map) throws Exception {
        if (userService.passwordCheck(map) == 0){
            throw new Exception("아이디 또는 비밀번호가 잘못되었습니다.");
        }
        return "로그인에 성공했습니다.";
        //return "success-page";
    }
}
