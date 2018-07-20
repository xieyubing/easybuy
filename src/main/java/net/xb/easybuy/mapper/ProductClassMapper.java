package net.xb.easybuy.mapper;

import net.xb.easybuy.baen.Product_Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by asus on 2017/6/20.
 */
@Mapper
public interface ProductClassMapper {

    int insert(Product_Category category);

    int delete(Integer id);

    int update(Product_Category category);

    Product_Category findById(Integer id);

    List<Product_Category> findAll();

    List<Product_Category> findClass();

    List<Product_Category> findSmallClass(Integer id);

}
