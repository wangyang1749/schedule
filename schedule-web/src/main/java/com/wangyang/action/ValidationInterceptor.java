package com.wangyang.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class ValidationInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        ActionContext actionContext = invocation.getInvocationContext();
        ServletContext context  = (ServletContext) actionContext.get(StrutsStatics.SERVLET_CONTEXT);
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
        IUserService userService = (IUserService) ctx.getBean("userService");

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String methodName = invocation.getProxy().getMethod();
        Method method = invocation.getAction().getClass().getMethod(methodName);

        if(method.isAnnotationPresent(Validation.class)){
            String token=null;
            Cookie[] cookies = request.getCookies();
            for(Cookie cookie:cookies){//遍历cookie数组
//                System.out.println(cookie.getName());//获取cookie的名字
//                System.out.println(cookie.getValue()); //获取cookie的值
                if(cookie.getName().equals("token")){
                    token =cookie.getValue();
                }
            }
            System.out.println("Interception---:"+token);
            User user = userService.getUserByToken(token);
            if(user==null){
//                response.sendRedirect("user_loginInput");
                return "loginInput";
            }else{
                request.setAttribute("user",user);
                return invocation.invoke();
            }
        }


        return invocation.invoke();
    }
}
