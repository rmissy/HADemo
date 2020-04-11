package com.rmissy.haserver.utils;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
 
/**
 * 作者 ： LZ
 * time ： 2017/6/8
 */
public class SynSystemDateUtils {
 
    public static void main(String[] args) {
        String date = "2017-11-11";
        String time = "11:11:11"  ;
        updateSysDateTime(date,time);
    }
 
    /**
     * 修改系统时间
     * yyyy-MM-dd HH:mm:ss
     * @param dataStr_   2017-11-11   yyyy-MM-dd
     * @param timeStr_   11:11:11     HH:mm:ss
     */
    public static void updateSysDateTime(String dataStr_,String timeStr_){
        try {
            String osName = System.getProperty("os.name");
            // Window 系统
            if (osName.matches("^(?i)Windows.*$")) {
                String cmd;
                // 格式：yyyy-MM-dd
                cmd = " cmd /c date " + dataStr_;
                Runtime.getRuntime().exec(cmd);
                // 格式 HH:mm:ss
                cmd = " cmd /c time " + timeStr_;
                Runtime.getRuntime().exec(cmd);
                System.out.println("windows 时间修改");
            } else if (osName.matches("^(?i)Linux.*$")) {
                // Linux 系统 格式：yyyy-MM-dd HH:mm:ss   date -s "2017-11-11 11:11:11"
                FileWriter excutefw = new FileWriter("/usr/updateSysTime.sh");
                BufferedWriter excutebw=new BufferedWriter(excutefw);
                excutebw.write("date -s \"" + dataStr_ +" "+ timeStr_ +"\"\r\n");
                excutebw.close();
                excutefw.close();
                String cmd_date ="sh /usr/updateSysTime.sh";
                Runtime.getRuntime().exec(cmd_date);
                System.out.println("cmd :" + cmd_date + " date :" + dataStr_ +" time :" + timeStr_);
                System.out.println("linux 时间修改");
            } else {
                System.out.println("操作系统无法识别");
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
 
}
