package com.yunzhijia.linkerp.model;

import java.io.Serializable;

/**
 * 获取令牌参数
 * 
 * @author cunshan_lu
 * @date 2017年10月13日 下午1:38:31
 */
public class TokenParam implements Serializable {

    private static final long serialVersionUID = 8625895791130818973L;
    /**
     * 签名
     */
    protected String signature;
    /**
     * 应用id
     */
    protected String appId;
    /**
     * 随机字符串
     */
    protected String nonceStr;
    /**
     * unix 时间戳
     */
    protected String timestamp;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
