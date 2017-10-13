package com.yunzhijia.linkerp.service;

import com.yunzhijia.linkerp.model.AccessToken;
/**
 * 令牌 Service
 * @author cunshan_lu
 * @date 2017年10月13日 下午1:51:10
 */
public interface AccessTokenService {
    /**
     * 获取令牌
     * @author cunshan_lu
     * @date 2017年10月13日 下午1:51:34
     * @return
     */
    AccessToken getAccessToken();

    /**
     * 刷新令牌
     * @author cunshan_lu
     * @date 2017年10月13日 下午1:51:47
     * @return
     */
    AccessToken refreshToken();
}
