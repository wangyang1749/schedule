package com.wangyang.filter;


import javax.servlet.*;
import java.io.IOException;

public class PageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String Spage =request.getParameter("pageIndex");
        int page;
        try {
            page = Integer.parseInt(Spage);
        } catch (NumberFormatException e) {
            page = 1;
        }
        try {
            //一页显示20条数据
            SystemContext.setPageSize(20);
            SystemContext.setPageIndex(page);
            chain.doFilter(request,response);
        } finally {
            SystemContext.removePageIndex();
            SystemContext.removePageSize();
        }
    }

    @Override
    public void destroy() {

    }
}
