package com.kingdoms.thekingdonsproject.service;

import com.kingdoms.thekingdonsproject.model.CommentDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final String NAMESPACE = "mapper.CommentMapper";

    private SqlSession session;

    private CommentService(SqlSession session){
        this.session = session;
    }

    public void insertComment(CommentDTO commentDTO){
        session.insert(NAMESPACE + ".insertcomment", commentDTO);
    }

    public List<CommentDTO> getComments(int postId){
        return session.selectList(NAMESPACE + ".getComments", postId);
    }
}
