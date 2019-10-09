package com.wangyang.filter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import javax.servlet.*;
import java.io.IOException;

public class ScheduleValidation implements Filter {

    private static WebApplicationContext webApplicationContext;

    private static IUserService userService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest)request;
//        HttpServletResponse resp = (HttpServletResponse)response;
//        System.out.println("filter");
//        Cookie[] cookies = req.getCookies();
//        String token=null;
//        for(Cookie cookie:cookies){//遍历cookie数组
//            System.out.println(cookie.getName());//获取cookie的名字
//            System.out.println(cookie.getValue()); //获取cookie的值
//            if(cookie.getName().equals("token")){
//                token=cookie.getName();
//            }
//        }
//        User user = userService.getUserByToken(token);
//        if(user==null){
//            resp.sendRedirect("loginInput.jsp");
//            System.out.println("用户没有登录！！");
//            return;
//        }else{
//            req.setAttribute("user",user);
//            chain.doFilter(request,response);
//        }


    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
        userService = (IUserService)webApplicationContext.getBean("userService");

    }

    @Override
    public void destroy() {

    }
}
