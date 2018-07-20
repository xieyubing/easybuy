package net.xb.easybuy.mapper;

import net.xb.easybuy.baen.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by asus on 2017/6/20.
 */
@Mapper
public interface ProductMapper {

    int insert(Product product);

    int delete(Integer id);

    int update(Product product);

    Product findById(Integer id);

    List<Product> findByIds(Integer id);

    List<Product> findAll();

    int findAllCount();

    List<Product> PageProduct(@Param("param1")Integer param1,@Param("param2") Integer param2);

}
