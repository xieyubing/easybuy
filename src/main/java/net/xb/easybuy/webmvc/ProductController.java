package net.xb.easybuy.webmvc;

import net.xb.easybuy.baen.PagBean;
import net.xb.easybuy.baen.Product;
import net.xb.easybuy.baen.Product_Category;
import net.xb.easybuy.service.ProductClassService;
import net.xb.easybuy.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asus on 2017/6/20.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Resource
    ProductService productService;
    @Resource
    ProductClassService productClassService;

    /**
     * 分页显示产品信息
     * @param model
     * @return
     */
    @RequestMapping("/manageProduct")
    public String manageProduct(Model model,@RequestParam(defaultValue = "1")Integer cur){
        PagBean p = new PagBean();
        int coun = productService.findAllCount();
        p.setTotal_count(coun);//总共统计飞数据
        p.setUnit_count(3);//一页显示3条
        p.setTotal_page(0);
        p.setCur_page(cur);//当前页面
        int start = (p.getCur_page()-1)*p.getUnit_count();
        List<Product> products = productService.PageProduct(start,p.getUnit_count());
        int[] arr = new int[p.getTotal_page()];
        for (int i=0;i<arr.length;i++){
            arr[i] = i+1;
        }
        model.addAttribute("cur_page",p.getCur_page());
        model.addAttribute("total_page",arr);
        model.addAttribute("products",products);
        return "/manage/product";
    }

    @RequestMapping("/DeleteProduct")
    public String DeleteProduct(@RequestParam("id") int id,
                                Model model){
        int a = productService.delete(id);
        if (a>0){
            return "manage-result";
        }
        model.addAttribute("DeleteMsg","删除失败");
        return "/manage/product";
    }

    @RequestMapping("/manageProductClass")
    public String manageProductClass(Model model){
        List<Product_Category> categories1 = productClassService.findClass();
        Map<Product_Category,List<Product_Category>> map = new HashMap<>();
        for (Product_Category p : categories1) {
            map.put(p,productClassService.findSmallClass(p.getEpc_id()));
        }
        model.addAttribute("map",map);
        return "/manage/productClass";
    }

    @RequestMapping("/toProductAdd")
    public String toProductAdd(Model model){
        List<Product_Category> categories1 = productClassService.findClass();
        Map<Product_Category,List<Product_Category>> map = new HashMap<>();
        for (Product_Category p : categories1) {
            map.put(p,productClassService.findSmallClass(p.getEpc_id()));
        }
        model.addAttribute("map",map);
        return "/manage/product-add";
    }

    @RequestMapping("/manageProductClassM")
    public String manageProductClassM(Model model,
                                      @RequestParam("id") Integer id){
        List<Product_Category> categories = productClassService.findClass();
        Product_Category product_category = productClassService.findById(id);
        model.addAttribute("categories",categories);
        model.addAttribute("product_category",product_category);
        return "/manage/productClass-modify";
    }


    @RequestMapping("/ProductView")
    public String ProductView(@RequestParam("id") Integer id,Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "product-view";
    }

    @RequestMapping("/toProductClassAdd")
    public String toProductClassAdd(Model model){
        List<Product_Category> categories = productClassService.findClass();
        model.addAttribute("categories",categories);
        return "/manage/productClass-add";
    }

    @RequestMapping("/toProductList")
    public String toProductList(Model model,@RequestParam("id") Integer id){
        List<Product> products = productService.findByIds(id);
        model.addAttribute("products",products);
        return "product-list";
    }

    @RequestMapping("/manageProductM")
    public String manageProductM(@RequestParam("id") Integer id,Model model){
        Product product = productService.findById(id);
        List<Product_Category> categories1 = productClassService.findClass();
        Map<Product_Category,List<Product_Category>> map = new HashMap<>();
        for (Product_Category p : categories1) {
            map.put(p,productClassService.findSmallClass(p.getEpc_id()));
        }
        model.addAttribute("map",map);
        model.addAttribute("product",product);
        return"/manage/product-modify";
    }

    @RequestMapping("/manageProductAdd")
    public String manageProductAdd(@RequestParam("id") Integer id,@RequestParam("Name") String name,
                                   @RequestParam("parentId") Integer parentId,@RequestParam("productPrice") Double productPrice,
                                   @RequestParam("productName") String productName,@RequestParam("productStock") Integer productStock) {
        Product product = new Product();
        product.setEp_id(id);
        product.setEp_name(name);
        product.setEp_price(productPrice);
        product.setEpc_id(parentId);
        product.setEp_description(productName);
        product.setEp_stock(productStock);
        int a = productService.update(product);
        if (a>0){
            return "/manage/manage-result";
        }
        return "/manage/product-modify";
    }


}
