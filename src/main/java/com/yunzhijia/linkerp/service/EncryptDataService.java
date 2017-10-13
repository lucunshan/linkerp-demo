package com.yunzhijia.linkerp.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.yunzhijia.linkerp.model.EncryptDataVo;

/**
 * 数据加解密
 * 
 * @author cunshan_lu
 * @date 2017年10月13日 下午1:54:57
 */
public interface EncryptDataService {
    String encryptData(String data) throws Exception;

    <T> T decryptData(String encryptData, Class<T> t) throws Exception;

    JSONObject decryptData(String encryptData) throws Exception;

    <T> List<T> decryptArrayData(String encryptData, Class<T> t) throws Exception;

}
