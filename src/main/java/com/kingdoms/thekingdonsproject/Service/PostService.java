package com.kingdoms.thekingdonsproject.Service;


import com.kingdoms.thekingdonsproject.Model.PostDTO;
import com.kingdoms.thekingdonsproject.Model.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final String NAMESPACE = "mapper.postMapper.";
    private SqlSession session;

    private PostService(SqlSession session) {
        this.session = session;
    }

    public void insertPost(PostDTO postDTO) {
        session.insert(NAMESPACE + "postInsert", postDTO);
        System.out.println("postDTO = " + postDTO);

    }

    public PostDTO selectPost(int postId) {
        return session.selectOne(NAMESPACE + "selectOne", postId);
    }

    public List<PostDTO> selectAllPost() {
        List<PostDTO> postList = session.selectList(NAMESPACE + "selectAll");
        System.out.println(postList);
        return postList;
    }
}




