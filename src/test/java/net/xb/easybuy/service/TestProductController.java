package net.xb.easybuy.service;

import net.xb.easybuy.baen.PagBean;
import net.xb.easybuy.baen.Product;
import net.xb.easybuy.baen.Product_Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asus on 2017/6/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProductController {

    @Autowired
    ProductClassService productClassService;

    @Autowired
    ProductService productService;

    @Test
    public void manageProductClass(){
        List<Product_Category> categories1 = productClassService.findClass();
        Map<Product_Category,List<Product_Category>> map = new HashMap<>();
        for (Product_Category p : categories1) {
            map.put(p,productClassService.findSmallClass(p.getEpc_id()));
        }

        for (Product_Category a:map.keySet() ) {
            System.out.println(""+a.getEpc_name()+" ---------------- "+map.get(a));
        }

    }

    @Test
    public void manageProduct(){
        PagBean p = new PagBean();
        int coun = productService.findAllCount();
        p.setTotal_count(coun);
        p.setUnit_count(3);
        p.setTotal_page(0);
        p.setCur_page(3);

        int start = (p.getCur_page()-1)*p.getUnit_count();
        List<Product> products = productService.PageProduct(start,p.getUnit_count());
        System.out.println("当前页数：0"+p.getCur_page()+"每页显示的条数:"+p.getUnit_count()+"总记录数是:"+p.getTotal_count());
        for (Product a:products) {
            System.out.println(a.getEp_name()+"");
        }
        int[] arr = new int[p.getTotal_page()];
        for (int i=0;i<p.getTotal_page();i++){
            arr[i] = i+1;
        }
        System.out.println("总页数"+arr.length);
    }


}
