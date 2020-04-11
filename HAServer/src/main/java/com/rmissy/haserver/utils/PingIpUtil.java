package com.rmissy.haserver.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.TimeZone;

public class PingIpUtil {

    /**
     * 校验是否可以连通
     *
     * @param ip
     * @return true/false
     */
    public static boolean isConnect(String ip) {
        boolean connect = false;
        Runtime runtime = Runtime.getRuntime();
        Process process;
        try {
            process = runtime.exec("ping " + ip);
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            is.close();
            isr.close();
            br.close();

            if (null != sb && !sb.toString().equals("")) {
                String logString = "";
                if (sb.toString().indexOf("TTL") > 0) {
                    // 网络畅通      
                    connect = true;
                } else {
                    // 网络不畅通      
                    connect = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connect;
    }

    public static void main(String[] args) throws Exception {
        //PingIpUtil netState = new PingIpUtil();
        //System.out.println("ping结果:" + isConnect("172.16.10.152"));
        test();
    }
    public static void test() throws Exception {
        String host = "www.secsmart.com";
        int timeOut = 3000;
        //超时应该在3钞以上
        boolean status = InetAddress.getByName(host).isReachable(timeOut);
        System.out.println(status);
        //TimeZone.setDefault(TimeZone.getTimeZone("GMT+8")); // 时区设置
        URL url=new URL("http://www.secsmart.com");//取得资源对象
        URLConnection uc=url.openConnection();//生成连接对象
        uc.connect(); //发出连接
        long ld=uc.getDate(); //取得网站日期时间（时间戳）
        Date date=new Date(ld); //转换为标准时间对象
        //分别取得时间中的小时，分钟和秒，并输出
        System.out.print(date.getHours()+"时"+date.getMinutes()+"分"+date.getSeconds()+"秒");
        System.out.println((new java.text.SimpleDateFormat("HH:mm:ss")).format(date));
    }
}