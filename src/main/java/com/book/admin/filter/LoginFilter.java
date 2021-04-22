package com.book.admin.filter;


import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName LoginFifter
 * @Description TODO
 * @Author zhanghan.a
 * Data 2021/4/22 16:30
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest= (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
        Cookie[] cookies = httpServletRequest.getCookies();
        String requestURI = httpServletRequest.getRequestURI();
        if ("/index.html".equals(requestURI) || "/register.html".equals(requestURI))
        {
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        if (cookies == null)
        {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/index.html");
            return;
        }
        for (Cookie cookie :cookies) {
            if ("email".equals(cookie.getName())) {
                filterChain.doFilter(servletRequest,servletResponse);
                return; }
        }
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/index.html");
        return;
    }

    @Override
    public void destroy() {

    }
}
