package com.yunzhijia.linkerp.model;

/**
 * 自定义数据表表头项
 * 
 * @author cunshan_lu
 * @date 2017年9月20日 下午4:22:22
 */
public class HeaderItemVo {
    /**
     * 表头项中文名称
     */
    private String name;

    /**
     * 表头项数据类型 目前支持string,number,timestamp
     */
    private String dataType;

    public HeaderItemVo(String name, String dataType) {
        super();
        this.name = name;
        this.dataType = dataType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public String toString() {
        return "HeaderItem [name=" + name + ", dataType=" + dataType + "]";
    }

}