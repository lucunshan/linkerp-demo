package com.yunzhijia.linkerp.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunzhijia.linkerp.model.EncryptDataVo;
import com.yunzhijia.linkerp.service.EncryptDataService;
import com.yunzhijia.linkerp.util.AESUtil;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncryptDataServiceImpl implements EncryptDataService {

    @Value("${aesKey}")
    private String aesKey;

    @Override
    public String encryptData(String data) throws Exception {
        try {
            String encryptdata = AESUtil.encrypt(data, aesKey);
            return encryptdata;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public <T> T decryptData(String encryptData, Class<T> clazz) throws Exception {
        try {
            String data = AESUtil.decrypt(encryptData, aesKey);
            return JSONObject.parseObject(data, clazz);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public JSONObject decryptData(String encryptData) throws Exception {
        try {
            String data = AESUtil.decrypt(encryptData, aesKey);
            return JSONObject.parseObject(data);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public <T> List<T> decryptArrayData(String encryptData, Class<T> clazz) throws Exception {
        try {
            String data = AESUtil.decrypt(encryptData, aesKey);
            return JSONArray.parseArray(data, clazz);
        } catch (Exception e) {
            throw e;
        }
    }

}
