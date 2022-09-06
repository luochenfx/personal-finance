package com.luochen.financial.base;

/**
 * 常见的返回码
 */
public enum ResultCode {
    SUCCESS(200, "请求成功"),
    FAIL(500, "请求失败");
    private final Integer code;
    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
