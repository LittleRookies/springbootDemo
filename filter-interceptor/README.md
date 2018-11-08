# springboot过滤器与拦截器

###  Filter— 过滤器

1. 配置类方式

   新建一个过滤器。

   ```java
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
   ```

   然后创建配置类，在springboot中注册自定义的过滤器

   ```java
   @Configuration
   public class FilterConfig {
       @Bean
       public FilterRegistrationBean<MyFilter> registFilter() {
           FilterRegistrationBean<MyFilter> registration = new FilterRegistrationBean<MyFilter>();
           registration.setFilter(new MyFilter());
   //        指定url的匹配模式
           registration.addUrlPatterns("/*");
           registration.setName("MyFilter");
           registration.setOrder(1);
           return registration;
       }
   }
   ```

2. 注解方式

   在新建的过滤器中加上注解`@WebFilter(urlPatterns = "/*", filterName = "MyFilter")`.

   然后在启动类中利用`@ServletComponentScan`注解扫描新建的过滤器。

### Interceptor— 拦截器

1. 自定义拦截器



   ```java
   public class MyHandlerInterceptor implements HandlerInterceptor {
       long start = System.currentTimeMillis();
   
       /*
        * 进入controller层之前拦截请求
        */
       @Override
       public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
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
   ```

   拦截的顺序是按照`preHandle、postHandle、afterCompletion`。

2. 在springboot中注册自定义拦截器。

   ```java
   @Configuration
   public class HandlerInterceptorConfig implements WebMvcConfigurer {
       @Override
       public void addInterceptors(InterceptorRegistry registry) {
           registry.addInterceptor(new MyHandlerInterceptor()).addPathPatterns("/**");
           WebMvcConfigurer.super.addInterceptors(registry);
       }
   }
   ```


