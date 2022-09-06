package com.luochen.financial.base;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用返回对象
 */
@Data
public class Response implements Serializable {

    private int code;
    private String desc;
    private long timestamp;
    private Object data;

    public Response(){}


    public Response(ResultCode resultCode){
        parseResult(resultCode);
    }


    public static Response success(){
        return new Response(ResultCode.SUCCESS);
    }

    public static Response success(Object data){
        Response response = new Response(ResultCode.SUCCESS);
        response.setData(data);
        return response;
    }

    public static Response fail(String message){
        Response response = new Response();
        response.parseResult(ResultCode.FAIL);
        response.setDesc(message);
        return response;
    }

    public static Response fail(Object data){
        Response response = new Response();
        response.data = data;
        response.parseResult(ResultCode.FAIL);
        return response;
    }

    public void parseResult(ResultCode resultCode){
        setCode(resultCode.getCode());
        setDesc(resultCode.getMessage());
        setTimestamp(System.currentTimeMillis());
    }

}
