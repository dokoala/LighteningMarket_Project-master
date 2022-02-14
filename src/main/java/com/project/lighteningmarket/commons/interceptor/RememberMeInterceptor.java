package com.project.lighteningmarket.commons.interceptor;

import com.project.lighteningmarket.user.domain.UserVO;
import com.project.lighteningmarket.user.service.UserService;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RememberMeInterceptor extends HandlerInterceptorAdapter {

    @Inject
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession httpSession = request.getSession();
        Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");

        // loginCookie 존재 : loginCookie 정보를 이용해 사용자 정보가 존재하는지 확인
        if(loginCookie != null) {
            UserVO userVO = userService.checkLoginBefore(loginCookie.getValue());
            // 사용자 정보 존재 : HttpSession에 회원의 정보 넣어줌
            if(userVO != null) {
                httpSession.setAttribute("login", userVO);
            }
        }

        return true;
    }
}
