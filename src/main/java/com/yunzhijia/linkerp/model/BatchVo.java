package com.yunzhijia.linkerp.model;

/**
 * 批次参数
 * 
 * @author cunshan_lu
 * @date 2017年10月13日 下午2:08:55
 */
public class BatchVo {
    /**
     * 工作圈eid
     */
    private String eid;
    /**
     * 批次号，由上传数据时线下产生
     */
    private String batchId;

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

    @Override
    public String toString() {
        return "BatchVo [eid=" + eid + ", batchId=" + batchId + "]";
    }

}
