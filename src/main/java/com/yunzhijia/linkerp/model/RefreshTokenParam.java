package com.yunzhijia.linkerp.model;
/**
 * 刷新令牌参数
 * @author cunshan_lu
 * @date 2017年10月13日 下午1:44:28
 */
public class RefreshTokenParam extends TokenParam {

    private static final long serialVersionUID = -6956678562943283522L;
    /**
     * 刷新令牌
     */
    private String refreshToken;

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
