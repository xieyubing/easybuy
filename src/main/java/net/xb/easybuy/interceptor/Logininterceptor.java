package net.xb.easybuy.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by asus on 2017/6/30.
 */
public class Logininterceptor extends HandlerInterceptorAdapter{

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
        String url = request.getRequestURI().toString();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null){
            if (url.contains("/toS") ||url.contains("/ProductView") || url.contains("/del")|| url.contains("/manage")){
               modelAndView.setViewName("login");
            }
        }
        if (url.contains("/erro")){
            modelAndView.setViewName("erro");
        }
    }

}
