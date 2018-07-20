package net.xb.easybuy.mapper;

import net.xb.easybuy.baen.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by asus on 2017/6/19.
 */
@Mapper
public interface UserMapper {

    // 插入用户
    int insert(User user);

    // 删除用户
    int delete(String id);

    // 更新用户
    int update(User user);

    // 按标识符查询用户
    User findById(String id);

    List<User> findAll();

    User login(@Param("username") String username, @Param("password") String password);

    int findAllCount();

    List<User> PageUser(@Param("param1")Integer param1,@Param("param2") Integer param2);

}
