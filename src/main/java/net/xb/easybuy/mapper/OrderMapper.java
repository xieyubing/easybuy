package net.xb.easybuy.mapper;

import net.xb.easybuy.baen.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by asus on 2017/6/20.
 */
@Mapper
public interface OrderMapper {

    int insert(Order order);

    int delete(String id);

    int update(Order order);

    Order findById(Integer id);

    List<Order> findAll();

    int findAllCount();

    List<Order> PageProduct(@Param("param1")Integer param1, @Param("param2") Integer param2);

}
