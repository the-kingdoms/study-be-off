package com.kingdoms.thekingdonsproject.Controller;

import com.kingdoms.thekingdonsproject.Model.UserDTO;
import com.kingdoms.thekingdonsproject.Service.UserService;
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
    public void test(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_name("성우");
        userDTO.setEmail("123@naver.com");
        userDTO.setPassword("1234");
        System.out.println(userDTO);

        userService.inserUser(userDTO);
    }

}
