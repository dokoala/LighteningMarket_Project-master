package com.project.lighteningmarket.commons.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInterceptor extends HandlerInterceptorAdapter {

    private static final String LOGIN = "login";
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    // Controller 수행 후 실행
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HttpSession httpSession = request.getSession();
        ModelMap modelMap = modelAndView.getModelMap();
        Object userVO = modelMap.get("user");

        if(userVO != null) {
            logger.info("new login success");
            httpSession.setAttribute(LOGIN, userVO);
//          response.sendRedirect("/");

            // 자동 로그인
            if(request.getParameter("useCookie") != null) {
                logger.info("remember me...");
                // 쿠키 생성
                Cookie loginCookie = new Cookie("loginCookie", httpSession.getId());
                loginCookie.setPath("/");
                loginCookie.setMaxAge(60*60*24);
                // 전송
                response.addCookie(loginCookie);
            }

             // 자동 페이지 처리
            Object destination = httpSession.getAttribute("destination");
            response.sendRedirect(destination != null ? (String) destination : "/");
        }
    }

    // Controller 수행 전 실행
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession httpSession = request.getSession();
        // 기존의 로그인 정보 제거
        if(httpSession.getAttribute(LOGIN) != null) {
            logger.info("clear login data before");
            httpSession.removeAttribute(LOGIN);
        }

        return true;
    }
}
