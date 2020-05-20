package com.example.demo59.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SessionInterceptor implements WebMvcConfigurer {

    /**
     * 自定义拦截器，添加拦截路径和排除拦截路径
     * addPathPatterns():添加需要拦截的路径
     * excludePathPatterns():添加不需要拦截的路径
     */
    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        List list = new ArrayList();
//        list.add("/user/logInUser");
//        list.add("/admin/logInAdmin");
//        list.add("/user/register");
//        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/**").excludePathPatterns(list);

    }
}