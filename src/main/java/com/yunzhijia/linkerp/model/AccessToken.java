package com.yunzhijia.linkerp.model;

import java.io.Serializable;

/**
 * 访问令牌
 * @author cunshan_lu
 * @date 2017年10月13日 下午1:37:34
 */
public class AccessToken implements Serializable {

    private static final long serialVersionUID = 363872451913215924L;
    /**
     * 令牌
     */
    private String accessToken;
    /**
     * 过期时间(秒)
     */
    private int expireIn;

    /**
     * 刷新令牌
     */
    private String refreshToken;

    /**
     * 创建时间
     */
    private long createTime;

    public AccessToken() {
        super();
        this.createTime = System.currentTimeMillis();
    }

    public boolean isExpire() {
        return this.createTime + this.expireIn * 1000 < System.currentTimeMillis() - 1000 * 60 * 5;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "AccessToken [accessToken=" + accessToken + ", expireIn=" + expireIn + ", refreshToken=" + refreshToken + ", createTime=" + createTime
                + "]";
    }

}
