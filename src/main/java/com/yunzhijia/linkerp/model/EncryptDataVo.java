package com.yunzhijia.linkerp.model;

/**
 * 加密数据参数
 * 
 * @author cunshan_lu
 * @date 2017年10月13日 下午2:11:20
 */
public class EncryptDataVo {
    /**
     * 加密数据
     */
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "EncryptDataVo[" + "data='" + data + ']';
    }
}
