package hq.hq.toupiao;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpTest {

	public void toupiao(String ip) throws IOException{
//		HttpHost proxy = new HttpHost("127.0.0.1", 8888);
//		DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
//		CloseableHttpClient httpclient = HttpClients.custom()
//		        .setRoutePlanner(routePlanner)
//		        .build();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httpPost = new HttpPost("http://b.csztv.cn/px/pollOk/20");
            httpPost.setHeader("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/7.0)");
            httpPost.setHeader("Accept", "application/x-ms-application, image/jpeg, application/xaml+xml, image/gif, image/pjpeg, application/x-ms-xbap, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");
            httpPost.setHeader("Accept-Language", "zh-CN");
            httpPost.setHeader("X-FORWARDED-FOR", ip);
            List <NameValuePair> nvps = new ArrayList <NameValuePair>();
            nvps.add(new BasicNameValuePair("option[1][]", "594"));	//唐建伟
//            nvps.add(new BasicNameValuePair("option[1][]", "591"));	//王建生
            nvps.add(new BasicNameValuePair("phonenum", "13000000000"));
            nvps.add(new BasicNameValuePair("pid", "20"));
            nvps.add(new BasicNameValuePair("sid", "0"));
            nvps.add(new BasicNameValuePair("capta", "9999"));
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            CloseableHttpResponse response2 = httpclient.execute(httpPost);
            try {
//            	System.out.println("测试中文");
//                System.out.println(response2.getStatusLine());
                HttpEntity entity2 = response2.getEntity();
                System.out.println(EntityUtils.toString(entity2));
                // do something useful with the response body
                // and ensure it is fully consumed
                EntityUtils.consume(entity2);
            } finally {
                response2.close();
            }
        } finally {
            httpclient.close();
        }
	}

    public void memberTest() throws IOException{
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            //请求地址
            HttpPost httpPost = new HttpPost("http://10.14.41.165:8011/Service.ashx");
            //Post字符串
            String data = "201204261002{\"AccountID\":\"f97f1493-692e-483d-bea0-1937f269c42a\",\"MethodName\":\"QueryMember\",\"MethodVersion\":1,\"Namespace\":\"TongCheng.SOA.Interface.TCMember.Main.Entities\",\"ReqTime\":\"\\/Date(1465366892273+0800)\\/\",\"Version\":\"201204261002\"}#tcsoa#TongCheng.SOA.Interface.TCMember.Main.Entities.QueryMemberRequest#tcsoa#TongCheng.SOA.Interface.TCMember.Main.Entities, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null#tcsoa#{\"AccessToken\":null,\"Act\":{\"AppKey\":\"QA.Test\",\"AppSecret\":\"2e44d22f-5353-40cc-a3c1-0819faf0fb86\"},\"Ip\":\"10.101.64.72\",\"MemberSystem\":0,\"QueryKey\":18652332951,\"QueryType\":3}";

            httpPost.setEntity(new StringEntity(data));
            CloseableHttpResponse response = httpclient.execute(httpPost);

            try {
                HttpEntity entity = response.getEntity();
                System.out.println(EntityUtils.toString(entity));
                // do something useful with the response body
                // and ensure it is fully consumed
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
	

}
