package net.xb.easybuy.service;

import net.xb.easybuy.baen.Product;
import net.xb.easybuy.baen.User;
import net.xb.easybuy.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by asus on 2017/6/20.
 */
@Service
@Transactional(readOnly = true)
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Transactional(readOnly = false)
    public int insert(Product product){
        return productMapper.insert(product);
    }

    @Transactional(readOnly = false)
    public int update(Product product){
        return productMapper.update(product);
    }

    @Transactional(readOnly = false)
    public int delete(Integer id){
        return productMapper.delete(id);
    }

    public Product findById(Integer id){
        return productMapper.findById(id);
    }

    public List<Product> findByIds(Integer id){
        return productMapper.findByIds(id);
    }

    public List<Product> findAll(){
        return productMapper.findAll();
    }

    public int findAllCount(){
        return productMapper.findAllCount();
    }

    public List<Product> PageProduct(Integer param1,Integer param2){
        return productMapper.PageProduct(param1,param2);
    }
}
