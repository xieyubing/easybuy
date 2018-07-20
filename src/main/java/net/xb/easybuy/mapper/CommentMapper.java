package net.xb.easybuy.mapper;

import net.xb.easybuy.baen.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by asus on 2017/6/21.
 */
@Mapper
public interface CommentMapper {

    int insert(Comment comment);

    int delete(String id);

    int update(Comment comment);

    Comment findById(Integer id);

    List<Comment> findAll();

    int findAllCount();

    List<Comment> PageProduct(@Param("param1")Integer param1, @Param("param2") Integer param2);


}
