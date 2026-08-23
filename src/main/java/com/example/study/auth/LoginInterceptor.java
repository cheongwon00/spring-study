package com.example.study.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if(session==null){
            response.sendRedirect("/auth/login");
            return false;
        }
        if(session.getAttribute("userId")==null){
            response.sendRedirect("/auth/login");
            return false;
        }
        return true;
    }
}
