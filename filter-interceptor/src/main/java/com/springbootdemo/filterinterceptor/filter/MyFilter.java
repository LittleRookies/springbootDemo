package com.springbootdemo.filterinterceptor.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/8 11:03
 */
//实现记录请求执行时间
//@WebFilter(urlPatterns = "/*", filterName = "MyFilter")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("服务启动！");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Execute cost=" + (System.currentTimeMillis() - start));
    }

    @Override
    public void destroy() {
        System.out.println("服务关闭！");
    }
}
