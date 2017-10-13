package com.yunzhijia.linkerp.model;

/**
 * 数据表Id参数
 * 
 * @author cunshan_lu
 * @date 2017年10月13日 下午2:10:21
 */
public class TableInfoIdParam {
    /**
     * 数据表Id
     */
    private String tableInfoId;

    public String getTableInfoId() {
        return tableInfoId;
    }

    public void setTableInfoId(String tableInfoId) {
        this.tableInfoId = tableInfoId;
    }

    @Override
    public String toString() {
        return "TableInfoIdParam [tableInfoId=" + tableInfoId + "]";
    }

}
