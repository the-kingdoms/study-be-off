package com.kingdoms.thekingdonsproject.Service;

import com.kingdoms.thekingdonsproject.Model.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final String NAMESPACE = "mapper.UserMapper.";
    private SqlSession session;

    private UserService(SqlSession session){
        this.session = session;

    }
    public void inserUser(UserDTO userDTO){
        session.insert(NAMESPACE + "user_insert", userDTO);
    }


    public UserDTO selectUser(int userId) {
        return session.selectOne(NAMESPACE+"selectOne", userId);
    }

    public List<UserDTO> selectAllUser() {
        List<UserDTO> a = session.selectList(NAMESPACE+"selectAll");
        System.out.println(a);
        return a;
    }
}
