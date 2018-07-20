package net.xb.easybuy.config;

import net.xb.easybuy.interceptor.Logininterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by asus on 2017/6/19.
 */
@Configuration
@ComponentScan("net.xb.easybuy.webmvc")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/manage").setViewName("/manage/index");
        registry.addViewController("/user/toLogin").setViewName("login");
        registry.addViewController("/user/toUserAdd").setViewName("/manage/user-add");
        registry.addViewController("/user/toRegister").setViewName("register");
        registry.addViewController("/news/toNewsAdd").setViewName("/manage/news-add");
        registry.addViewController("/order/toShoppingResult").setViewName("/shopping-result");
        registry.addViewController("/product/toProductAdd").setViewName("/manage/product-add");
    }


    @Bean
    public Logininterceptor loginInterceptor() {
        return new Logininterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor());
    }

}
