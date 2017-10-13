package com.yunzhijia.linkerp.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.yunzhijia.linkerp.constant.URLConstant;
import com.yunzhijia.linkerp.model.AccessToken;
import com.yunzhijia.linkerp.model.RefreshTokenParam;
import com.yunzhijia.linkerp.model.TokenParam;
import com.yunzhijia.linkerp.model.TokenResult;
import com.yunzhijia.linkerp.service.AccessTokenService;
import com.yunzhijia.linkerp.util.HttpUtils;
import com.yunzhijia.linkerp.util.RandomUtils;
import com.yunzhijia.linkerp.util.SignUtils;

@Service
public class AccessTokenServiceImpl implements AccessTokenService {
    @Value("${appId}")
    private String oauthAppId;
    @Value("${secret}")
    private String oauthSecret;
    @Value("${aesKey}")
    private String oauthAesKey;
    @Value("${yzjHost}")
    private String yzjHost;

    private static AccessToken accessToken = null;

    public AccessToken getAccessToken() {
        if (accessToken == null || accessToken.isExpire()) {
            synchronized (AccessTokenServiceImpl.class) {
                if (accessToken == null || accessToken.isExpire()) {
                    TokenParam param = new TokenParam();
                    // appid
                    param.setAppId(oauthAppId);
                    // 随机字符串
                    param.setNonceStr(RandomUtils.randomKey(10));
                    // unix 时间戳
                    param.setTimestamp(System.currentTimeMillis() + "");
                    // 签名(appid，随机字符串、unix 时间戳、开发者screct)
                    param.setSignature(SignUtils.sign(param.getAppId(), param.getNonceStr(), param.getTimestamp(), oauthSecret));
                    String body = HttpUtils.postJson(yzjHost + URLConstant.GETTEAMACCESSTOKEN, param);
                    System.out.println(body);
                    // body对象：accessToken、createTime（创建时间）、expire（是否到期）、expireIn（有效时间）、refreshToken（刷新的token）
                    TokenResult<AccessToken> result = JSONObject.parseObject(body, new TypeReference<TokenResult<AccessToken>>() {
                    });
                    if (result != null && result.isSuccess()) {
                        // access_token
                        accessToken = result.getData();
                    }
                }
            }

        }
        return accessToken;
    }

    public AccessToken refreshToken() {
        AccessToken t = getAccessToken();
        if (t == null) {
            return null;
        }
        RefreshTokenParam param = new RefreshTokenParam();
        param.setAppId(oauthAppId);
        param.setNonceStr(RandomUtils.randomKey(10));
        param.setTimestamp(System.currentTimeMillis() + "");
        param.setRefreshToken(t.getRefreshToken());
        param.setSignature(SignUtils.sign(param.getAppId(), param.getNonceStr(), param.getTimestamp(), param.getRefreshToken(), oauthSecret));
        String body = HttpUtils.postJson(yzjHost + URLConstant.REFRESHTOKEN, param);
        System.out.println(body);
        TokenResult<AccessToken> result = JSONObject.parseObject(body, new TypeReference<TokenResult<AccessToken>>() {
        });
        if (result != null && result.isSuccess()) {
            // access_token
            accessToken = result.getData();
        }
        return accessToken;
    }
}
