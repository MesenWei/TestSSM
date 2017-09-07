package com.demo.java.xml;


import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maosheng on 2017/6/7.
 */
public class HttpSendXml {
    /**
     * @param args
     */
    public static void main(String[] args) {

        String url = "http://localhost:8088/callback/inside";

        post(url, getXmlInfo2());
    }

    public static void post(String url, String xmlFileName) {
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            try {
                HttpPost httppost = new HttpPost(url);
                String str = EntityUtils.toString(new UrlEncodedFormEntity(new ArrayList<NameValuePair>()));
                httppost.setURI(new URI(httppost.getURI().toString() + "?"
                        + str));

                StringEntity stringEntity = new StringEntity(xmlFileName, "UTF-8");
                stringEntity.setContentEncoding("UTF-8");
                stringEntity.setContentType("application/xml");

                httppost.setEntity(stringEntity);
                CloseableHttpResponse response = httpclient.execute(httppost);
                try {
                    HttpEntity resEntity = response.getEntity();
                } finally {
                    response.close();
                }
            } finally {
                httpclient.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private static String getXmlInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName>aaaaaaaaaaaaaaaaaaaaaaaaaaa</ToUserName>");
        sb.append("<AgentID>1</AgentID>");
        sb.append("<Encrypt>bbbbbbbbbbbbbbbbbbbbbbbbbbbb</Encrypt>");
        sb.append("</xml>");

        return sb.toString();
    }

    private static String getXmlInfo2() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[toUser]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[fromUser]]></FromUserName>");
        sb.append("<CreateTime>1348831860</CreateTime>");
        sb.append("<MsgType><![CDATA[text]]></MsgType>");
        sb.append("<Content><![CDATA[this is a test]]></Content>");
        sb.append("<MsgId>1234567890123456</MsgId>");
        sb.append("</xml>");

        return sb.toString();
    }
}
