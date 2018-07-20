package net.xb.easybuy.service;

import net.xb.easybuy.baen.Comment;
import net.xb.easybuy.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by asus on 2017/6/21.
 */
@Service
@Transactional(readOnly = true)
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public List<Comment> findAll(){
        return commentMapper.findAll();
    }

    @Transactional(readOnly = false)
    public int update(Comment comment){
        return commentMapper.update(comment);
    }

    public Comment findById(Integer id){
        return commentMapper.findById(id);
    }

    @Transactional(readOnly = false)
    public int delete(String id){
        return commentMapper.delete(id);
    }


    public int findAllCount(){
        return commentMapper.findAllCount();
    }

    public List<Comment> PageProduct(Integer param1,Integer param2){
        return commentMapper.PageProduct(param1,param2);
    }
}
