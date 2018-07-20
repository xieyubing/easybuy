package net.xb.easybuy.webmvc;

import net.xb.easybuy.baen.Order;
import net.xb.easybuy.baen.PagBean;
import net.xb.easybuy.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by asus on 2017/6/20.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping("/manageOrder")
    public String manageOrder(Model model,@RequestParam(defaultValue = "1")Integer cur){
        PagBean p = new PagBean();
        int coun = orderService.findAllCount();
        p.setTotal_count(coun);//总共统计飞数据
        p.setUnit_count(6);//一页显示3条
        p.setTotal_page(0);
        p.setCur_page(cur);//当前页面
        int start = (p.getCur_page()-1)*p.getUnit_count();
        List<Order> orders = orderService.PageProduct(start,p.getUnit_count());
        int[] arr = new int[p.getTotal_page()];
        for (int i=0;i<arr.length;i++){
            arr[i] = i+1;
        }
        model.addAttribute("cur_page",p.getCur_page());
        model.addAttribute("total_page",arr);
        model.addAttribute("orders",orders);
        return "/manage/order";
    }

    @RequestMapping("/manageOrderM")
    public String manageOrderM(@RequestParam("id")Integer id, Model model){
        Order order = orderService.findById(id);
        model.addAttribute("order",order);
        return "/manage/order-modify";
    }

    @RequestMapping("/manageOrderMUp")
    public String manageOrderMUp(Model model,@RequestParam("orderId") Integer orderId,
                                 @RequestParam("name") String name,
                                 @RequestParam("address") String address,
                                 @RequestParam("status") Integer status){

        Order order = new Order();
        order.setEo_id(orderId);
        order.setEo_user_name(name);
        order.setEo_user_address(address);
        order.setEo_status(status);
        int a=orderService.update(order);
        if (a>0) {
            return "/manage/manage-result";
        }
        return "/manage/modify";
    }

    @RequestMapping("DeleteOrder")
    public String DeleteOrder(@RequestParam("id") String id,Model model){
        int a = orderService.delete(id);
        if (a>0){
            return "/manage/manage-result";
        }
        model.addAttribute("DeleteMsg","删除失败");
        return "/manage/order";
    }

}
