package com.kingdoms.thekingdonsproject.service;

import com.kingdoms.thekingdonsproject.model.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final String NAMESPCE = "mapper.UserMapper";
    private SqlSession session;

    private UserService(SqlSession session){
        this.session = session;
    }

    public void insertUser(UserDTO userDTO){
        session.insert(NAMESPCE + ".insert", userDTO);
    }
}
