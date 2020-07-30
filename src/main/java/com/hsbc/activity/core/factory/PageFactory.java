package com.hsbc.activity.core.factory;


import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Class 分页工厂
 * Created by wwx193433
 * 2019-09-30 11:50
 */
public class PageFactory {

    /**
     * 接口调用 GET
     */
    public static void httpURLConectionGET(String urls) {
        try {
            URL url = new URL(urls); // 把字符串转换为URL请求地址
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接
            connection.connect();// 连接会话
            // 获取输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {// 循环读取流
                sb.append(line);    //写入对象中
            }
            br.close();// 关闭流
            connection.disconnect();// 断开连接
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("请求失败!");
        }
    }

    public static void main(String[] args) {
        httpURLConectionGET("https://www.cnblogs.com");
    }


}
