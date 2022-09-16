package com.luochen.financial.filter;

import com.luochen.financial.base.Response;

import java.lang.annotation.*;

/**
 * <p>标记一个类或方法的返回值不需要使用{@link Response}包装</p>
 * @see Response
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface ResponseResult {
}
