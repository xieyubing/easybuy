package net.xb.easybuy.mapper;

import net.xb.easybuy.baen.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by asus on 2017/6/20.
 */
@Mapper
public interface NewsMapper {

    int insert(News news);

    int delete(String id);

    int update(News news);

    News findById(Integer id);

    List<News> findAll();

    int findAllCount();

    List<News> PageProduct(@Param("param1")Integer param1, @Param("param2") Integer param2);


}
