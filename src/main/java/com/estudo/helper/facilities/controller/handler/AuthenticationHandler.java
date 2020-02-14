package com.estudo.helper.facilities.controller.handler;

import com.estudo.helper.facilities.controller.annotation.LoginRequired;
import com.estudo.helper.facilities.controller.exception.MissingHeaderFieldException;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationHandler implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        LoginRequired loginRequired = handlerMethod.getMethod().getAnnotation(LoginRequired.class);
        if (loginRequired == null) {
            return true;
        }

        String token = request.getHeader("Authorization");

        if (StringUtils.isBlank(token)) {
            throw new MissingHeaderFieldException("Nao ha token");
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
