package net.xb.easybuy.webmvc;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import net.xb.easybuy.baen.Comment;
import net.xb.easybuy.baen.PagBean;
import net.xb.easybuy.baen.Product;
import net.xb.easybuy.baen.User;
import net.xb.easybuy.service.CommentService;
import net.xb.easybuy.service.ProductService;
import net.xb.easybuy.service.UserService;
import net.xb.easybuy.utli.StringToDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by asus on 2017/6/19.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private CommentService commentService;

    @Autowired
    private Producer captchaProducer;

    @Resource
    private ProductService productService;

    @RequestMapping("/login")
    public String login(@RequestParam("userName") String username,
                        @RequestParam("passWord") String password,
                       @RequestParam("veryCode") String very,
                        HttpSession session, Model model){
        String Code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (very==null || !very.equals(Code)){
            model.addAttribute("loginMsg","验证码错误");
            return "login";
        }
        User user = userService.login(username,password);
        if (user != null){
            session.setAttribute("username",username);
            System.out.printf(""+username);
            if (user.getEu_status() == 2){
                return "manage/manage-result";
            }else {
                return "index";
            }
        }else {
            model.addAttribute("loginMsg","登录失败,用户名或者密码错误");
            return "login";
        }
    }



    @RequestMapping("/register")
    public String register(@RequestParam("userName") String username,
                           @RequestParam("passWord") String password,
                           @RequestParam("veryCode") String very,
                           HttpSession session, Model model){
        String Code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (!very.equals(Code)) {
            model.addAttribute("registerMsg", "验证码错误");
            return "register";
        }
        Date date = new Date();
        // 设置用户为普通用户
        int popedom = 1;
        User user = new User();
        user.setEu_user_id(username);
        user.setEu_password(password);
        user.setEu_birthday(date);
        user.setEu_status(popedom);
        int count = userService.insert(user);
        if (count>0){
            return "reg-result";
        }else {
            model.addAttribute("registerMsg","注册失败！");
            return "register";
        }
    }

    @RequestMapping("/manageUser")
    public String manageUser(Model model,@RequestParam(defaultValue = "1")Integer cur){
        PagBean p = new PagBean();
        int coun = userService.findAllCount();
        p.setTotal_count(coun);//总共统计飞数据
        p.setUnit_count(5);//一页显示3条
        p.setTotal_page(0);
        p.setCur_page(cur);//当前页面
        int start = (p.getCur_page()-1)*p.getUnit_count();
        List<User> users = userService.PageUser(start,p.getUnit_count());
        int[] arr = new int[p.getTotal_page()];
        for (int i=0;i<arr.length;i++){
            arr[i] = i+1;
        }
        model.addAttribute("cur_page",p.getCur_page());
        model.addAttribute("total_page",arr);
        model.addAttribute("users",users);
        return "/manage/user";
    }

    @RequestMapping("/manageUserM")
    public String manageUserM(@RequestParam("id") String id,
                             Model model){
        User user = userService.findById(id);
        if (user.getEu_birthday() != null){
            String date = StringToDate.toString(user.getEu_birthday());
            String[] sourceStrArray = date.split("-");
            model.addAttribute("birthyear",sourceStrArray[0]);
            model.addAttribute("birthmonth",sourceStrArray[1]);
            model.addAttribute("birthday",sourceStrArray[2]);
        }
        model.addAttribute("user",user);
        return "/manage/user-modify";
    }
    @RequestMapping("/manageUp")
    public String manageUp(@RequestParam("userName") String id,
                            @RequestParam("name") String name,
                            @RequestParam("passWord") String passWord,
                            @RequestParam("sex") int sex,
                            @RequestParam("birthyear") String birthyear,
                            @RequestParam("birthmonth") String birthmonth,
                            @RequestParam("birthday")String birthday,
                            @RequestParam("mobile") String mobile,
                            @RequestParam("address")String address){
        User user = new User();
        user.setEu_user_id(id);
        user.setEu_user_name(name);
        user.setEu_password(passWord);
        if (sex==1){
            user.setEu_sex('男');
        }else {
            user.setEu_sex('女');
        }
        String date = birthyear+"-"+birthmonth+"-"+birthday;
        user.setEu_birthday(StringToDate.toDate(date));
        user.setEu_mobile(mobile);
        user.setEu_address(address);
        user.setEu_status(1);
        int a = userService.update(user);
        if (a>0){
            return "/manage/manage-result";
        }
        return "/manage/user-modify";
    }

    @RequestMapping("/manageGuestbook")
    public String manageGuestbook(Model model,@RequestParam(defaultValue = "1")Integer cur){
        PagBean p = new PagBean();
        int coun = commentService.findAllCount();
        p.setTotal_count(coun);//总共统计飞数据
        p.setUnit_count(6);//一页显示3条
        p.setTotal_page(0);
        p.setCur_page(cur);//当前页面
        int start = (p.getCur_page()-1)*p.getUnit_count();
        List<Comment> comments = commentService.PageProduct(start,p.getUnit_count());
        int[] arr = new int[p.getTotal_page()];
        for (int i=0;i<arr.length;i++){
            arr[i] = i+1;
        }
        model.addAttribute("cur_page",p.getCur_page());
        model.addAttribute("total_page",arr);
        model.addAttribute("comments",comments);
        return "/manage/guestbook";
    }

    @RequestMapping("/outLogin")
    public String outLogin(HttpSession session){
        session.removeAttribute("username");
        return "index";
    }

    @RequestMapping("DeleteUser")
    public String DeleteUser(@RequestParam("id") String id,Model model){
        int a = userService.delete(id);
        if (a>0){
            return "/manage/manage-result";
        }
        model.addAttribute("DeleteMsg","删除失败");
        return "/user/manageUser";
    }

    @RequestMapping("DeleteComment")
    public String DeleteComment(@RequestParam("id") String id,Model model){
        int a = commentService.delete(id);
        if (a>0){
            return "/manage/manage-result";
        }
        model.addAttribute("DeleteMsg","删除失败");
        return "/user/manageUser";
    }
    @RequestMapping("/getKaptchaImage")
    public ModelAndView getKaptchaImage(
            HttpServletResponse response,HttpSession session) throws Exception {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control",
                "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        String capText = captchaProducer.createText();
        System.out.println("capText: " + capText);
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY,capText);
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }


    @RequestMapping("/manageGuestbookM")
    public String manageGuestbookM(@RequestParam("id") Integer id,
                                   Model model){
        Comment comment = commentService.findById(id);
        model.addAttribute("comment",comment);


        return "/manage/guestbook-modify";
    }

    @RequestMapping("/guestbookM")
    public String guestbookM(@RequestParam("orderId") Integer orderId,
                             @RequestParam("name") String name,
                             @RequestParam("replyContent")String replyContent,
                             Model model){
        Comment comment = new Comment();
        comment.setEc_id(orderId);
        comment.setEc_nick_name(name);
        comment.setEc_reply(replyContent);
        comment.setEc_reply_time(new Date());
        int a = commentService.update(comment);
        if (a>0){
            return "/manage/manage-result";
        }
        model.addAttribute("modifyMsg","修改失败");
        return "/manage/guestbook-modify";
    }


    @RequestMapping("/manageUserAdd")
    public String manageUserAdd(@RequestParam("userName") String userId,
                                @RequestParam("name") String name,
                                @RequestParam("passWord") String passWord,
                                @RequestParam("sex") int sex,
                                @RequestParam("birthyear") String birthyear,
                                @RequestParam("birthmonth") String birthmonth,
                                @RequestParam("birthday")String birthday,
                                @RequestParam("mobile") String mobile,
                                @RequestParam("address")String address){
        User user = new User();
        user.setEu_user_id(userId);
        user.setEu_user_name(name);
        user.setEu_password(passWord);
        if (sex==1){
            user.setEu_sex('男');
        }else {
            user.setEu_sex('女');
        }
        String date = birthyear+"-"+birthmonth+"-"+birthday;
        user.setEu_birthday(StringToDate.toDate(date));
        user.setEu_mobile(mobile);
        user.setEu_address(address);
        user.setEu_status(1);
        int a = userService.insert(user);
        if (a>0){
            return "/manage/manage-result";
        }else {
            return "/manage/user-add";
        }

    }


    @RequestMapping("/toShopping")
    public String toShopping(HttpSession session,
                             Model model){
        // 从session里获取购物车（键：商品标识符；值：购买数量）
        LinkedHashMap<Integer, Integer> cart = (LinkedHashMap<Integer, Integer>) session.getAttribute("cart");
        if (cart == null) {
            System.out.println("为空");
            cart = new LinkedHashMap<Integer, Integer>();
            session.setAttribute("cart", cart);
        }else {
            double totalPrice = 0.0;
            List<HashMap<String, Object>> shoppingTable = new ArrayList<HashMap<String, Object>>();
            for (Integer p_id : cart.keySet()) {
                Product product = productService.findById(p_id);
                HashMap<String, Object> shoppingItem = new HashMap<String, Object>();
                shoppingItem.put("img", product.getEp_file_name());
                shoppingItem.put("id", product.getEp_id());
                shoppingItem.put("name", product.getEp_name());
                shoppingItem.put("amount", cart.get(p_id));
                shoppingItem.put("sum", product.getEp_price() * cart.get(p_id));
                shoppingTable.add(shoppingItem);
                totalPrice = totalPrice + (Double) shoppingItem.get("sum");
            }
            session.setAttribute("totalPrice", totalPrice);
            session.setAttribute("shoppingTable", shoppingTable);
        }
        return "shopping";
    }

    @RequestMapping("/addShopping")
    public @ResponseBody
    Map<String,Object> addShopping(Model model,HttpSession session,@RequestParam("id") Integer id){
        Map<String, Object> map = new HashMap<String, Object>();
        LinkedHashMap<Integer, Integer> cart = (LinkedHashMap<Integer, Integer>) session.getAttribute("cart");
        if (cart == null) {
            cart = new LinkedHashMap<Integer, Integer>();
            session.setAttribute("cart", cart);
        }
        if (cart.containsKey(id)) {
            cart.put(id, cart.get(id) + 1);
            map.put("count", cart.get(id));
        } else {
            cart.put(id, 1);
            map.put("count", cart.get(id));
        }
        return map;
    }
    @RequestMapping("/reduceShopping")
    public @ResponseBody
    Map<String,Object> reduceShopping(HttpSession session,@RequestParam("id") Integer id){
        Map<String, Object> map = new HashMap<String, Object>();
        LinkedHashMap<Integer, Integer> cart = (LinkedHashMap<Integer, Integer>) session.getAttribute("cart");
        if (cart.containsKey(id)) {
            if (cart.get(id) - 1 == 0){
                cart.remove(id);
                map.put("count", cart.get(id));
            }else {
                cart.put(id, cart.get(id) - 1);
                map.put("count", cart.get(id));
            }
        }
        return map;
    }

    @RequestMapping("/delShopping")
    public @ResponseBody Map<String,Object> delShopping(HttpSession session,@RequestParam("id") Integer id){
        Map<String, Object> map = new HashMap<String, Object>();
        LinkedHashMap<Integer, Integer> cart = (LinkedHashMap<Integer, Integer>) session.getAttribute("cart");
        if (cart.remove(id)>0){
            map.put("count", cart.get(id));
        }
        return map;
    }



    @RequestMapping("/toShoppingJ")
    public String toShoppingJ(){
        return "shopping-result";
    }

    @RequestMapping("/toGuestbook")
    public String toGuestbook(Model model,@RequestParam(defaultValue = "1")Integer cur){
        PagBean p = new PagBean();
        int coun = commentService.findAllCount();
        p.setTotal_count(coun);//总共统计飞数据
        p.setUnit_count(3);//一页显示3条
        p.setTotal_page(0);
        p.setCur_page(cur);//当前页面
        int start = (p.getCur_page()-1)*p.getUnit_count();
        List<Comment> comments = commentService.PageProduct(start,p.getUnit_count());
        int[] arr = new int[p.getTotal_page()];
        for (int i=0;i<arr.length;i++){
            arr[i] = i+1;
        }
        model.addAttribute("cur_page",p.getCur_page());
        model.addAttribute("total_page",arr);
        model.addAttribute("comments",comments);
        return "guestbook";
    }

}
