package com.yunzhijia.linkerp.service;

import java.util.List;

import com.yunzhijia.linkerp.model.CategoryWithReportTableVo;
import com.yunzhijia.linkerp.model.DataSaveStatus;
import com.yunzhijia.linkerp.model.BatchVo;
import com.yunzhijia.linkerp.model.TableInfoDataVo;
import com.yunzhijia.linkerp.model.TableInfoHeaderVo;
/**
 * 开放接口服务
 * @author cunshan_lu
 * @date 2017年10月13日 下午1:55:43
 */
public interface OpenApiService {
    /**
     * 获取轻应用管理员权限内所有报表分类及OpenApi创建的数据表信息
     * @author cunshan_lu
     * @date 2017年10月13日 下午1:56:05
     * @param eid
     * @param accessToken
     * @return
     */
    List<CategoryWithReportTableVo> getAdminTableInfos(String eid, String accessToken);

    /**
     * 创建数据表头
     * @author cunshan_lu
     * @date 2017年10月13日 下午1:56:34
     * @param header
     * @param accessToken
     * @return
     */
    String CreateReportTableInfoHeader(TableInfoHeaderVo header, String accessToken);

    /**
     * 上传数据表数据
     * @author cunshan_lu
     * @date 2017年10月13日 下午1:56:46
     * @param tableData
     * @param accessToken
     * @return
     */
    boolean SaveReportTableInfoData(TableInfoDataVo tableData, String accessToken);

    /**
     * 查询上传数据表数据上传结果
     * @author cunshan_lu
     * @date 2017年10月13日 下午1:56:58
     * @param batchVo
     * @param accessToken
     * @return
     */
    DataSaveStatus GetReportTableInfoDataSaveStatus(BatchVo batchVo, String accessToken);

}
