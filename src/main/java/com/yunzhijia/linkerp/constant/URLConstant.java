package com.yunzhijia.linkerp.constant;
/**
 * URL 常量
 * @author cunshan_lu
 * @date 2017年10月13日 下午1:36:31
 */
public class URLConstant {
    /**
     * 获取团队accessToken
     */
    public final static String GETTEAMACCESSTOKEN = "/gateway/oauth2/token/getTeamAccessToken";
    /**
     * 刷新accessToken
     */
    public final static String REFRESHTOKEN = "/gateway/oauth2/token/refreshToken";
    /**
     * 获取轻应用管理员权限内所有报表分类及数据表信息
     */
    public final static String GETADMINTABLEINFOS = "/api/open/linkerp/ReportDataTableapi/getAdminTableInfos";
    /**
     * 创建数据表头
     */
    public final static String CREATETABLEINFOHEADER = "/api/open/linkerp/customizedapi/createTableInfoHeader";
    /**
     * 上传数据表数据
     */
    public final static String SAVETABLEINFODATA = "/api/open/linkerp/customizedapi/saveTableInfoData";

    /**
     * 查询上传数据表数据上传结果
     */
    public final static String GETTABLEINFODATASAVESTATUS = "/api/open/linkerp/customizedapi/getTableInfoDataSaveStatus";
}
