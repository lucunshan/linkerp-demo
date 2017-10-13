package com.yunzhijia.linkerp.model;

/**
 * 数据保存状态
 * 
 * @author cunshan_lu
 * @date 2017年10月13日 下午2:12:21
 */
public class DataSaveStatus {
    /**
     * 数据保存状态: 0：进行中，1：成功，2：失败
     */
    private int status;
    /**
     * 错误信息
     */
    private String error;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ImportStatusVo [status=" + status + ", error=" + error + "]";
    }
}
