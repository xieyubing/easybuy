package net.xb.easybuy.service;

import net.xb.easybuy.baen.Order;
import net.xb.easybuy.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by asus on 2017/6/21.
 */
@Service
@Transactional(readOnly = true)
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public List<Order> findAll(){
       return orderMapper.findAll();
    }

    @Transactional(readOnly = false)
    public int delete(String id){
        return orderMapper.delete(id);
    }

    public Order findById(Integer id){
        return orderMapper.findById(id);
    }

    @Transactional(readOnly = false)
    public int update(Order order){
        return orderMapper.update(order);
    }

    public int findAllCount(){
        return orderMapper.findAllCount();
    }

    public List<Order> PageProduct(Integer param1,Integer param2){
        return orderMapper.PageProduct(param1,param2);
    }

}
