package net.xb.easybuy.service;

import net.xb.easybuy.baen.Product_Category;
import net.xb.easybuy.mapper.ProductClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by asus on 2017/6/20.
 */
@Service
@Transactional(readOnly = true)
public class ProductClassService {

    @Autowired
    private ProductClassMapper productClassMapper;

    @Transactional(readOnly = false)
    public int insert(Product_Category category){
        return productClassMapper.insert(category);
    }

    @Transactional(readOnly = false)
    public int update(Product_Category category){
        return productClassMapper.update(category);
    }

    @Transactional(readOnly = false)
    public int delete(Integer id){
        return productClassMapper.delete(id);
    }

    public Product_Category findById(Integer id){
        return productClassMapper.findById(id);
    }

    public List<Product_Category> findAll(){
        return productClassMapper.findAll();
    }

    public List<Product_Category> findClass(){
        return productClassMapper.findClass();
    }

    public List<Product_Category> findSmallClass(Integer id){
        return productClassMapper.findSmallClass(id);
    }
}
