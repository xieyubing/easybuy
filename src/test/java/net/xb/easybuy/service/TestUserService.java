package net.xb.easybuy.service;

import net.xb.easybuy.baen.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by asus on 2017/6/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserService {

    @Autowired
    private UserService userService;

    @Test
    public void testLogin(){
        String username = "black";
        String password = "44444";
        User user = userService.login(username,password);
        if (user != null){
            System.out.printf(""+user.getEu_user_name());
            System.out.printf(""+user.getEu_status());
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败");
        }
    }

    @Test
    public void testfindId(){
        User user  =userService.findById("aaa");
        if (user == null){
            System.out.println("失败");
        }else {
            System.out.println("成功");
        }
    }

    @Test
    public void tsetreg(){
        User user = new User();
        user.setEu_user_id("aaa");
        user.setEu_password("123456");
        user.setEu_status(1);
        int a = userService.insert(user);
        if (a>0){
            System.out.printf("注册成功");
        }else {
            System.out.printf("注册失败");
        }
    }
}
