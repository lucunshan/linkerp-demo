package com.yunzhijia.linkerp.model;

import java.util.List;

/**
 * 数据表表头信息
 * @author cunshan_lu
 * @date 2017年10月13日 下午2:00:59
 */
public class TableInfoHeaderVo {
    /**
     * 工作圈eid
     */
    private String eid;

    /**
     * 数据表名称
     */
    private String name;
    /**
     * 报表类别记录id
     */
    private String reportCategoryId;

    /**
     * 表头项
     */
    private List<HeaderItemVo> headerItems;

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReportCategoryId() {
        return reportCategoryId;
    }

    public void setReportCategoryId(String reportCategoryId) {
        this.reportCategoryId = reportCategoryId;
    }

    public List<HeaderItemVo> getHeaderItems() {
        return headerItems;
    }

    public void setHeaderItems(List<HeaderItemVo> headerItems) {
        this.headerItems = headerItems;
    }

    @Override
    public String toString() {
        return "TableInfoHeaderVo [eid=" + eid + ", name=" + name + ", reportCategoryId=" + reportCategoryId + ", headerItems=" + headerItems
                + "]";
    }

}
