package com.yunzhijia.linkerp.model;

import java.io.Serializable;
import java.util.List;
/**
 * 报表分类及自定义数据表值对象
 * @author cunshan_lu
 * @date 2017年10月13日 下午1:57:49
 */
public class CategoryWithReportTableVo implements Serializable {

    /** serialVersionUID: */
    private static final long serialVersionUID = -7097586869558861918L;

    /**
     * 报表分类ID
     */
    private String id;

    /**
     * 模板报表主题名称
     */
    private String name;

    /**
     * 数据表
     */
    private List<TableVo> tableInfos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TableVo> getTableInfos() {
        return tableInfos;
    }

    public void setTableInfos(List<TableVo> tableInfos) {
        this.tableInfos = tableInfos;
    }

    @Override
    public String toString() {
        return "CategoryWithReportTableVo [id=" + id + ", name=" + name + ", tableInfos=" + tableInfos + "]";
    }

}
