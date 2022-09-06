package com.luochen.financial.base;

import com.luochen.financial.filter.ResponseResult;
import com.luochen.financial.interceptor.ResponseResultInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 对Controller返回的{@code @ResponseBody}or {@code ResponseEntity} 后,{@code HttpMessageConverter} 类型转换之前拦截, 进行相应的处理操作后,再将结果返回
 */
@Slf4j
@ControllerAdvice
public class BaseResponseBodyAdvice implements ResponseBodyAdvice<Object>  {

    @Override
    public boolean supports(@NotNull MethodParameter returnType, @NotNull Class<? extends HttpMessageConverter<?>> converterType) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        ResponseResult responseResult = (ResponseResult) request.getAttribute(ResponseResultInterceptor.WRAP_RESPONSE_DATA);
        return responseResult == null;
    }

    @Override
    public Object beforeBodyWrite(Object body, @NotNull MethodParameter returnType, @NotNull MediaType selectedContentType, @NotNull Class<? extends HttpMessageConverter<?>> selectedConverterType, @NotNull ServerHttpRequest request, @NotNull ServerHttpResponse response) {
        if (body instanceof Exception) {
            return Response.fail(body);
        } else if (body instanceof Response) {
            return body;
        } else {
            return Response.success(body);
        }
    }
}
