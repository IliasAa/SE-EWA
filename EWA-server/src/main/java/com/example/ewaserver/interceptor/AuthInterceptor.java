package com.example.ewaserver.interceptor;

import com.example.ewaserver.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    private final UserService userService;

    public AuthInterceptor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  {
        String authHeader= request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer "))
            System.out.println("No bearer token");

        request.setAttribute("user", userService.getUserFromToken(authHeader.substring(7)));
        return true;
    }

}
