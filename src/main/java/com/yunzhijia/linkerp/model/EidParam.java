package com.yunzhijia.linkerp.model;

import java.io.Serializable;
/**
 * 企业eid参数
 * @author cunshan_lu
 * @date 2017年10月13日 下午2:11:51
 */
public class EidParam implements Serializable {
    /** serialVersionUID: */
    private static final long serialVersionUID = -3161080709745967746L;
    /**
     * 企业eid
     */
    private String eid;

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    @Override
    public String toString() {
        return "EidParam [eid=" + eid + "]";
    }

}
