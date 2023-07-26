package com.kingdoms.thekingdonsproject.service;

import com.kingdoms.thekingdonsproject.model.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class UserService {
    private final String NAMESPACE = "mapper.UserMapper";
    private SqlSession session;

    private UserService(SqlSession session){
        this.session = session;
    }

    public void insertUser(UserDTO userDTO){

        session.insert(NAMESPACE + ".insert", userDTO);
    }
    public int emailCheck(String email){
        return session.selectOne(NAMESPACE + ".checkEmail", email);
    }

    public int passwordCheck(Map<String, Object> map){
        return session.selectOne(NAMESPACE + ".checkPassword", map);
    }
}
