package com.bau.hotel.filter;

import com.bau.hotel.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        boolean resourceIsSafeToServe;

        String pathInfo = getPathInfo(request);
        if( pathInfo.startsWith("/secure") ){
            resourceIsSafeToServe = isUserLoggedIn(request);
        } else {
            resourceIsSafeToServe = true;
        }

        if( resourceIsSafeToServe ){
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect("/");
        }
    }

    private boolean isUserLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if( session != null ){
            User user = (User) session.getAttribute("user");
            if( user != null ){
                return true;
            }
        }
        return false;
    }

    private String getPathInfo(HttpServletRequest request) {
        String pathInfo = request.getServletPath();
        if( pathInfo == null ){
            pathInfo = "";
        }
        return pathInfo;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}