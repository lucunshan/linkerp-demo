package com.yunzhijia.linkerp.model;

/**
 * 数据表数据
 * 
 * @author cunshan_lu
 * @date 2017年10月13日 下午2:02:07
 */
public class TableInfoDataVo {
    /**
     * 企业工作圈eid
     */
    private String eid;
    /**
     * 批次id,有线下产生，每次传不重复随机值，建议使用uuid
     */
    private String batchId;
    /**
     * 报表分类Id
     */
    private String reportCategoryId;
    /**
     * 数据表Id，来源于创建数据表头返回值或已有数据表
     */
    private String tableInfoId;
    /**
     * 数据新增类型 1：增量；2：替换
     */
    private int addType;
    /**
     * 数据
     */
    private String data;

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getReportCategoryId() {
        return reportCategoryId;
    }

    public void setReportCategoryId(String reportCategoryId) {
        this.reportCategoryId = reportCategoryId;
    }

    public String getTableInfoId() {
        return tableInfoId;
    }

    public void setTableInfoId(String tableInfoId) {
        this.tableInfoId = tableInfoId;
    }

    public int getAddType() {
        return addType;
    }

    public void setAddType(int addType) {
        this.addType = addType;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TableInfoDataVo [eid=" + eid + ", batchId=" + batchId + ", reportCategoryId=" + reportCategoryId + ", tableInfoId=" + tableInfoId
                + ", addType=" + addType + ", data=" + data + "]";
    }

}
