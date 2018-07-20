package net.xb.easybuy.service;

import net.xb.easybuy.baen.User;
import net.xb.easybuy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by asus on 2017/6/19.
 */
@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = false)
    public int insert(User user){
        return userMapper.insert(user);
    }
    @Transactional(readOnly = false)
    public int update(User user){
        return userMapper.update(user);
    }
    @Transactional(readOnly = false)
    public int delete(String id){
        return userMapper.delete(id);
    }

    public User findById(String id){
        return userMapper.findById(id);
    }

    public List<User> findAll(){
        return userMapper.findAll();
    }

    public User login(String username, String password) {
        return userMapper.login(username,password);
    }

    public int findAllCount(){
        return userMapper.findAllCount();
    }

    public List<User> PageUser(Integer param1,Integer param2){
        return userMapper.PageUser(param1,param2);
    }
}
