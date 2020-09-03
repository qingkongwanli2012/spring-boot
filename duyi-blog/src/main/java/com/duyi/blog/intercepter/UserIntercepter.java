package com.duyi.blog.intercepter;

import cn.hutool.core.util.ObjectUtil;
import com.duyi.blog.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserIntercepter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        User user = (User) request.getSession().getAttribute("user");
        if (ObjectUtil.isEmpty(user)) {
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }
}
