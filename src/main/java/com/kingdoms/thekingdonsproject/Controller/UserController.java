package com.kingdoms.thekingdonsproject.Controller;

import com.kingdoms.thekingdonsproject.Model.UserDTO;
import com.kingdoms.thekingdonsproject.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;

    }

    @GetMapping("/test")
    public void test(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("성우");
        userDTO.setEmail("123@naver.com");
        userDTO.setPassword("1234");
        System.out.println(userDTO);

        userService.inserUser(userDTO);
    }


    @GetMapping("/selectone/{userId}")
    public void test1(@PathVariable Integer userId) {
        UserDTO u = userService.selectUser(userId);
        System.out.println(u);
    }

    @GetMapping("/selectall")
    public void test1() {
        List<UserDTO> u = userService.selectAllUser();
        System.out.println(u);
    }
}
