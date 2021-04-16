package com.kang.computer_room_management.common;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Utils {
    /**
     * @return 输入数字及窗口大小，返回窗口id
     */
    public int returnValueBy(int number,int window){
        if(number%window==0){
            return number/window;
        }
        else{
            return number/window+1;
        }
    }
    public String getDescription(int status){
        String description;
        switch (status){
            case 3:
                description="机房空闲";
                break;
            case 2:
                description="机房有空闲机位";
                break;
            case 1:
                description="机房已被预约";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + status);
        }
        return description;
    }

    public boolean isUserLogin(HttpServletRequest httpServletRequest){
        HttpSession httpSession=httpServletRequest.getSession();
        if(httpSession.getAttribute("uname")!=null&&httpSession.getAttribute("type").equals("user")){
            return true;
        }else {
            return false;
        }
    }
    public boolean isAdminLogin(HttpServletRequest httpServletRequest){
        HttpSession httpSession=httpServletRequest.getSession();
        if(httpSession.getAttribute("uname")!=null&&httpSession.getAttribute("type").equals("admin")){
            return true;
        }else {
            return false;
        }
    }

    //将status转成对应文本
    public String statusToString(int st){
        String status="";
        switch (st){
            case 0:
                status="机位预约成功";
                break;
            case 1:
                status="正在上机";
                break;
            case 2:
            case 7:
                status="使用结束";
                break;
            case 3:
                status="机房预约中";
                break;
            case 4:
                status="机房预约成功";
                break;
            case 5:
                status="机房预约失败";
                break;
            case 6:
                status="机房使用中";
                break;
            case 8:
                status="预约取消";
                break;
            default:break;
        }
        return status;
    }
    //将机房id转换成展示的机房号
    public String ridToShowId(int rid){
        int num1=returnValueBy(rid,3);
        int num3=rid%3==0?3:rid%3;
        return num1+"0"+num3;
    }
    //将真实机位id转换成机位号
    public int cidToShowId(int cid){
        int id;
        if(cid%30==0){
            id=30;
        }else {
            id=cid%30;
        }
        return id;
    }
    public List<Integer> activeStatus(){
        List<Integer> integers=new ArrayList<>();
        integers.add(0);
        integers.add(1);
        integers.add(3);
        integers.add(4);
        integers.add(6);
        return integers;
    }

    //
    public String articleClass(int rstatus,int arStatus){
        if(rstatus==1&&arStatus==3){
            return "style1";
        }else if(rstatus==1&&arStatus==6){
            return  "style2";
        }else {
            return "style3";
        }
    }
    public String articleImg(int rstatus,int arStatus){
        if(rstatus==1&&arStatus==3){
            return "images/pic01.jpg";
        }else if(rstatus==1&&arStatus==6){
            return  "images/pic02.jpg";
        }else {
            return "images/pic03.jpg";
        }
    }
    public String articleDescription(int rstatus,int arStatus){
        if(rstatus==1&&arStatus==3){
            return "待处理";
        }else if(rstatus==1&&arStatus==6){
            return  "已处理";
        }else {
            return "无需处理";
        }
    }
}
