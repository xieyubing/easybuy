package net.xb.easybuy.service;

import net.xb.easybuy.baen.News;
import net.xb.easybuy.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by asus on 2017/6/20.
 */
@Service
@Transactional(readOnly = true)
public class NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Transactional(readOnly = false)
    public int insert(News news){
        return newsMapper.insert(news);
    }

    @Transactional(readOnly = false)
    public int update(News news){
        return newsMapper.update(news);
    }

    @Transactional(readOnly = false)
    public int delete(String id){
        return newsMapper.delete(id);
    }

    public News findById(Integer id){
        return newsMapper.findById(id);
    }

    public List<News> findAll(){
        return newsMapper.findAll();
    }

    public int findAllCount(){
        return newsMapper.findAllCount();
    }

    public List<News> PageProduct(Integer param1,Integer param2){
        return newsMapper.PageProduct(param1,param2);
    }
}
