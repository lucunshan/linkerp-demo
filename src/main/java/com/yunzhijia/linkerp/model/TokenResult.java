package com.yunzhijia.linkerp.model;

import java.io.Serializable;
/**
 * 获取Token结果
 * @author cunshan_lu
 * @date 2017年10月13日 下午1:38:00
 */
public class TokenResult<T> implements Serializable {
    private static final long serialVersionUID = 9023057198146675331L;
    private boolean success;
    private int errorCode;
    private T data;
    private String error;

    @Override
    public String toString() {
        String value = "success:" + success;
        if (!success) {
            value += ", errorCode:" + errorCode + ",error:" + error + ",data:" + data;
        }
        return value;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
