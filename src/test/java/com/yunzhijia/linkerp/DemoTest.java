package com.yunzhijia.linkerp;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yunzhijia.linkerp.model.AccessToken;
import com.yunzhijia.linkerp.model.CategoryWithReportTableVo;
import com.yunzhijia.linkerp.model.DataSaveStatus;
import com.yunzhijia.linkerp.model.BatchVo;
import com.yunzhijia.linkerp.model.HeaderItemVo;
import com.yunzhijia.linkerp.model.TableInfoDataVo;
import com.yunzhijia.linkerp.model.TableInfoHeaderVo;
import com.yunzhijia.linkerp.model.TableInfoIdParam;
import com.yunzhijia.linkerp.service.AccessTokenService;
import com.yunzhijia.linkerp.service.OpenApiService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest {

    @Autowired
    private AccessTokenService accessTokenService;

    @Autowired
    private OpenApiService openApiService;

    /**
     * 获取令牌
     * 
     * @author cunshan_lu
     * @date 2017年10月13日 下午2:29:41
     */
    @Test
    public void testGetAccessToken() {
        AccessToken accessToken = accessTokenService.getAccessToken();
        System.out.println(accessToken);
    }

    /**
     * 刷新令牌
     * 
     * @author cunshan_lu
     * @date 2017年10月13日 下午2:30:01
     */
    @Test
    public void testrefreshToken() {
        AccessToken accessToken = accessTokenService.refreshToken();
        System.out.println(accessToken);
    }

    /**
     * 获取轻应用管理员权限内所有报表分类及OpenApi创建的数据表信息
     * 
     * @author cunshan_lu
     * @date 2017年10月13日 下午2:30:17
     */
    @Test
    public void testGetAdminTableInfos() {
        AccessToken accessToken = accessTokenService.getAccessToken();

        String eid = "6824227";

        List<CategoryWithReportTableVo> categoryWithReportTableVos = openApiService.getAdminTableInfos(eid, accessToken.getAccessToken());
        System.out.println(categoryWithReportTableVos);
    }

    /**
     * 创建数据表头
     * 
     * @author cunshan_lu
     * @date 2017年10月13日 下午2:32:08
     */
    @Test
    public void testCreateReportTableInfoHeader() {
        AccessToken accessToken = accessTokenService.getAccessToken();

        TableInfoHeaderVo header = new TableInfoHeaderVo();
        header.setEid("6824227");
        header.setName("自定义API测试");
        header.setReportCategoryId("59ae4c29b65a185fddf3decc"); // 报表分类Id
                                                                // 来源于AdminTableInfos

        List<HeaderItemVo> headerItems = new ArrayList<HeaderItemVo>();
        headerItems.add(new HeaderItemVo("表头1", "string"));
        headerItems.add(new HeaderItemVo("表头2", "number"));
        headerItems.add(new HeaderItemVo("表头3", "timestamp"));
        header.setHeaderItems(headerItems);

        TableInfoIdParam tableInfoIdParam = openApiService.createReportTableInfoHeader(header, accessToken.getAccessToken());
        System.out.println(tableInfoIdParam);
    }

    /**
     * 上传数据表数据
     * 
     * @author cunshan_lu
     * @date 2017年10月13日 下午2:32:31
     */
    @Test
    public void testSaveReportTableInfoData() {
        AccessToken accessToken = accessTokenService.getAccessToken();

        TableInfoDataVo tableData = new TableInfoDataVo();
        String testData = "[{\"表头1\":\"中国\",\"表头2\":\"100\",\"表头3\":\"2008-08-08 20:00:00\"},{\"表头1\":\"美国\",\"表头2\":\"80\",\"表头3\":\"2009-09-08 20:00:00\"},{\"表头1\":\"法国\",\"表头2\":\"115\",\"表头3\":\"2008-08-08 20:00:00\"}]";
        tableData.setEid("6824227");
        tableData.setReportCategoryId("59ae4c29b65a185fddf3decc"); // 来源于AdminTableInfos,与表头保持一致
        tableData.setTableInfoId("59e0847eb65a1861731a1bc8");// 来源于表头创建或已有数据表Id
        tableData.setAddType(0);
        tableData.setData(testData);
        tableData.setBatchId("GmdGyrsuqqPqZcZRLpwzxXvjbDXu88");// 批次id,每次传不重复随机值，建议使用uuid

        boolean status = openApiService.saveReportTableInfoData(tableData, accessToken.getAccessToken());

        System.out.println(status);
    }

    /**
     * z
     * 
     * @author cunshan_lu
     * @date 2017年10月13日 下午2:32:46
     */
    @Test
    public void testGetReportTableInfoDataSaveStatus() {
        AccessToken accessToken = accessTokenService.getAccessToken();

        BatchVo batchVo = new BatchVo();
        batchVo.setEid("6824227");
        batchVo.setBatchId("GmdGyrsuqqPqZcZRLpwzxXvjbDXu88"); // 数据上传使用的批次id

        DataSaveStatus status = openApiService.getReportTableInfoDataSaveStatus(batchVo, accessToken.getAccessToken());

        System.out.println(status);
    }

}
