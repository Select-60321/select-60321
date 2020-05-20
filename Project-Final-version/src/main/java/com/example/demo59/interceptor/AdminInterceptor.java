/*
package com.example.demo59.interceptor;

import com.example.demo59.entity.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        System.out.println("执行到了preHandle方法");
        System.out.println(handler);
        Admin user = (Admin) request.getSession().getAttribute("session_admin");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/admin/logInAdmin");//拦截后跳转的方法
            System.out.println("已成功拦截并转发跳转");
            return false;
        }
        System.out.println("合格不需要拦截，放行");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("执行了postHandle方法");
    }

    */
/*
     * 视图渲染之后的操作
     *//*

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
        System.out.println("执行到了afterCompletion方法");
    }

}*/
