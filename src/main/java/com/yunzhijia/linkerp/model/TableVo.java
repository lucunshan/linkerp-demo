package com.yunzhijia.linkerp.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 自定义数据表信息
 * @author cunshan_lu
 * @date 2017年10月13日 下午1:59:25
 */
public class TableVo implements Serializable {
    /**
     * 表信息id
     */
    private String id;

    /**
     * 表名称(中文)
     */
    private String name;

    /**
     * 数据库表数据更新时间
     */
    private Date dataUpdateTime;

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

    public Date getDataUpdateTime() {
        return dataUpdateTime;
    }

    public void setDataUpdateTime(Date dataUpdateTime) {
        this.dataUpdateTime = dataUpdateTime;
    }

    @Override
    public String toString() {
        return "TableVo [id=" + id + ", name=" + name + ", dataUpdateTime=" + dataUpdateTime + "]";
    }

}
