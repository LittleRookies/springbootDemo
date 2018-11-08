package com.springbootdemo.filterinterceptor.interceptor;


import com.springbootdemo.filterinterceptor.util.IpUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 *
 * @Author: Little Rookies
 * @Date: 2018/11/8 13:25
 */
public class MyHandlerInterceptor implements HandlerInterceptor {
    long start = System.currentTimeMillis();

    /*
     * 进入controller层之前拦截请求
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("请求ip：" + IpUtil.getIp(httpServletRequest));
        start = System.currentTimeMillis();
        System.out.println("preHandle-----进入controller层之前拦截请求");
        return true;
    }

    /*
     * 处理请求完成后视图渲染之前的处理操作
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("Interceptor cost=" + (System.currentTimeMillis() - start));
        System.out.println("postHandle-----处理请求完成后视图渲染之前的处理操作");
    }

    /*
     * 视图渲染之后的操作
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion-----视图渲染之后的操作");
    }
}
