package com.sapa.common;

public class ResponseResult<T> {
    private Integer status;

    private T data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public synchronized static <T> ResponseResult<T> e(ResponseCode code, T t) {
        ResponseResult<T> responseResult = new ResponseResult();
        responseResult.setStatus(code.code);
        responseResult.setData(t);
        return responseResult;
    }
}
