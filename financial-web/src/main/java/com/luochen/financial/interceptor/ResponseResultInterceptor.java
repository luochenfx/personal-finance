package com.luochen.financial.interceptor;

import com.luochen.financial.filter.ResponseResult;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 针对注解{@link ResponseResult}标识的类或方法添加预处理行为
 */
@Component
public class ResponseResultInterceptor implements HandlerInterceptor {

    public static final String WRAP_RESPONSE_DATA = "wrap_response";

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            if (clazz.isAnnotationPresent(ResponseResult.class)) {
                request.setAttribute(WRAP_RESPONSE_DATA, clazz.getAnnotation(ResponseResult.class));
            } else if (method.isAnnotationPresent(ResponseResult.class)) {
                request.setAttribute(WRAP_RESPONSE_DATA, method.getAnnotation(ResponseResult.class));
            }
        }
        return true;
    }
}
