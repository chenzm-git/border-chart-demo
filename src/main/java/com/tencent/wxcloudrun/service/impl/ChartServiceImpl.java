package com.tencent.wxcloudrun.service.impl;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * @author chenzm
 * @version V1.0
 * @since 2023-05-05$
 **/
@Service
public class ChartServiceImpl {

    private CloseableHttpClient httpclient = null;

    private String url = "http://23.247.131.178:8080/api/chart";

    public String chart(String input){
        String ret = "";

        if (httpclient == null) {
            httpclient = HttpClients.createDefault();
        }

        try {
            HttpPost post = new HttpPost(url);

            StringEntity entityIn = new StringEntity(input);
            post.setEntity(entityIn);

            // 执行get请求
            CloseableHttpResponse response = httpclient.execute(post);

            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // 返回响应内容
                    ret = EntityUtils.toString(entity);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                response.close();
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return ret;
    }


}
