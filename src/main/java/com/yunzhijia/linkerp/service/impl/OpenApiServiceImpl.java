package com.yunzhijia.linkerp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunzhijia.linkerp.constant.URLConstant;
import com.yunzhijia.linkerp.model.CategoryWithReportTableVo;
import com.yunzhijia.linkerp.model.DataSaveStatus;
import com.yunzhijia.linkerp.model.EidParam;
import com.yunzhijia.linkerp.model.EncryptDataVo;
import com.yunzhijia.linkerp.model.BatchVo;
import com.yunzhijia.linkerp.model.TableInfoDataVo;
import com.yunzhijia.linkerp.model.TableInfoHeaderVo;
import com.yunzhijia.linkerp.model.Result;
import com.yunzhijia.linkerp.model.TableInfoIdParam;
import com.yunzhijia.linkerp.service.EncryptDataService;
import com.yunzhijia.linkerp.service.OpenApiService;
import com.yunzhijia.linkerp.util.HttpUtils;

@Service
public class OpenApiServiceImpl implements OpenApiService {
    @Autowired
    private EncryptDataService encryptDataService;
    @Value("${yzjHost}")
    private String yzjHost;

    public List<CategoryWithReportTableVo> getAdminTableInfos(String eid, String accessToken) {
        List<CategoryWithReportTableVo> categoryWithReportTableVos = null;
        try {
            EidParam eidParam = new EidParam();
            eidParam.setEid(eid);
            String jsonParam = encryptDataService.encryptData(JSON.toJSONString(eidParam));
            EncryptDataVo vo = new EncryptDataVo();
            vo.setData(jsonParam);
            String url = yzjHost + URLConstant.GETADMINTABLEINFOS + "?accessToken=" + accessToken;
            String body = HttpUtils.postJson(url, vo);
            System.out.println(body);

            Result result = JSONObject.parseObject(body, Result.class);
            if (result != null && result.isSuccess()) {
                categoryWithReportTableVos = encryptDataService.decryptArrayData(result.getData(), CategoryWithReportTableVo.class);
            }
            else {
                // 根据错误码处理
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return categoryWithReportTableVos;
    }

    public String CreateReportTableInfoHeader(TableInfoHeaderVo header, String accessToken) {
        String tableInfoId = "";
        try {
            String jsonParam = encryptDataService.encryptData(JSON.toJSONString(header));
            EncryptDataVo vo = new EncryptDataVo();
            vo.setData(jsonParam);
            String url = yzjHost + URLConstant.CREATETABLEINFOHEADER + "?accessToken=" + accessToken;
            String body = HttpUtils.postJson(url, vo);
            System.out.println(body);

            Result result = JSONObject.parseObject(body, Result.class);
            if (result != null && result.isSuccess()) {
                TableInfoIdParam tableInfoIdParam = encryptDataService.decryptData(result.getData(), TableInfoIdParam.class);
                tableInfoId = tableInfoIdParam.getTableInfoId();
            }
            else {
                // 根据错误码处理
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return tableInfoId;
    }

    public boolean SaveReportTableInfoData(TableInfoDataVo tableData, String accessToken) {
        boolean success = false;
        try {
            String jsonParam = encryptDataService.encryptData(JSON.toJSONString(tableData));
            EncryptDataVo vo = new EncryptDataVo();
            vo.setData(jsonParam);
            String url = yzjHost + URLConstant.SAVETABLEINFODATA + "?accessToken=" + accessToken;
            String body = HttpUtils.postJson(url, vo);
            System.out.println(body);

            Result result = JSONObject.parseObject(body, Result.class);
            if (result != null && result.isSuccess()) {
                success = true;
            }
            else {
                // 根据错误码处理
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return success;
    }

    public DataSaveStatus GetReportTableInfoDataSaveStatus(BatchVo batchVo, String accessToken) {
        DataSaveStatus status = new DataSaveStatus();
        try {
            String jsonParam = encryptDataService.encryptData(JSON.toJSONString(batchVo));
            EncryptDataVo vo = new EncryptDataVo();
            vo.setData(jsonParam);
            String url = yzjHost + URLConstant.GETTABLEINFODATASAVESTATUS + "?accessToken=" + accessToken;
            String body = HttpUtils.postJson(url, vo);
            System.out.println(body);

            Result result = JSONObject.parseObject(body, Result.class);
            if (result != null && result.isSuccess()) {
                status = encryptDataService.decryptData(result.getData(), DataSaveStatus.class);
            }
            else {
                // 根据错误码处理
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }
}
