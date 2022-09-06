package com.luochen.financial.filter;

import com.luochen.financial.base.Response;

import java.lang.annotation.*;

/**
 * <p>标记一个类或方法的返回值是否需要包装</p>
 * <p>返回值包装类{@link Response}</p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface ResponseResult {
}
