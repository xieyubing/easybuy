package net.xb.easybuy;

import net.xb.easybuy.baen.News;
import net.xb.easybuy.baen.PagBean;
import net.xb.easybuy.baen.Product;
import net.xb.easybuy.baen.Product_Category;
import net.xb.easybuy.service.NewsService;
import net.xb.easybuy.service.ProductClassService;
import net.xb.easybuy.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SpringBootApplication
public class EasybuyApplication {

	@Resource
	private NewsService newsService;
	@Resource
	ProductClassService productClassService;
	@Resource
	ProductService productService;
	@RequestMapping("/")
	public String index(HttpSession session, Model model,@RequestParam(defaultValue = "1")Integer cur){
		if (session.getAttribute("newss") == null || session.getAttribute("productMap") == null){
			List<News> newss =newsService.findAll();
			List<Product_Category> categories1 = productClassService.findClass();
			Map<Product_Category,List<Product_Category>> map = new HashMap<>();
			for (Product_Category p : categories1) {
				map.put(p,productClassService.findSmallClass(p.getEpc_id()));
			}
			session.setAttribute("newss",newss);
			session.setAttribute("productMap",map);
		}
		PagBean p = new PagBean();
		int coun = productService.findAllCount();
		p.setTotal_count(coun);//总共统计飞数据
		p.setUnit_count(8);//一页显示3条
		p.setTotal_page(0);
		p.setCur_page(cur);//当前页面
		int start = (p.getCur_page()-1)*p.getUnit_count();
		List<Product> products = productService.PageProduct(start,p.getUnit_count());
		int[] arr = new int[p.getTotal_page()];
		for (int i=0;i<arr.length;i++){
			arr[i] = i+1;
		}
		session.setAttribute("cur_page",p.getCur_page());
		session.setAttribute("total_page",arr);
		session.setAttribute("products",products);
		return "index";
	}

	public static void main(String[] args) {
		SpringApplication.run(EasybuyApplication.class, args);
	}
}
