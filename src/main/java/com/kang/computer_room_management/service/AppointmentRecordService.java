package com.kang.computer_room_management.service;

import com.kang.computer_room_management.common.Utils;
import com.kang.computer_room_management.common.domain.*;
import com.kang.computer_room_management.mapper.AppointmentRecordMapper;
import com.kang.computer_room_management.mapper.StUserMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentRecordService implements IAppointmentRecordService {
    Utils utils=new Utils();
    final StUserMapper stUserMapper;
    final private AppointmentRecordMapper appointmentRecordMapper;
    @Autowired
    public AppointmentRecordService(StUserMapper stUserMapper, AppointmentRecordMapper appointmentRecordMapper) {
        this.stUserMapper = stUserMapper;
        this.appointmentRecordMapper = appointmentRecordMapper;
    }

    @Override
    public List<Integer> findRidInAppointment() {
        //查找在预约表且状态为0的机房id
        List<Integer> ridInA=new ArrayList<>();
        List<Integer> artstatus=new ArrayList<>();
        artstatus.add(3);
        artstatus.add(4);
        artstatus.add(6);
        AppointmentRecordExample appointmentRecordExample=new AppointmentRecordExample();
        appointmentRecordExample.createCriteria().andArstatusIn(artstatus);
        List<AppointmentRecord> appointmentRecords=appointmentRecordMapper.selectByExample(appointmentRecordExample);
        for(AppointmentRecord appointmentRecord:appointmentRecords)
            ridInA.add(appointmentRecord.getRid());
        return ridInA.size()>0?ridInA:null;
    }

    @Override
    public void setComputerAppointmentRecord(StUser stUser, Computer computer) {

    }

    @Override
    public void setRoomAppointmentRecord(StUser stUser, ComputerRoom computerRoom) {

    }

    @Override
    public void dealAppointmentRecord(Admin admin, ComputerRoom computerRoom) {

    }

    @Override
    public String showHistory(HttpServletRequest httpServletRequest) {
        HttpSession httpSession=httpServletRequest.getSession();
        int code=0;
        String uname="未登录";
        String uprofile="未登录";
        JSONArray jsonArray=new JSONArray();
        if (utils.isUserLogin(httpServletRequest)){
            code=1;
            int uid=(int)httpSession.getAttribute("uid");
            StUser stUser=stUserMapper.selectByPrimaryKey(uid);
            uname=stUser.getUname();
            uprofile=stUser.getUprofile();
            AppointmentRecordExample appointmentRecordExample=new AppointmentRecordExample();
            appointmentRecordExample.createCriteria().andUidEqualTo(uid);
            List<AppointmentRecord> appointmentRecords=appointmentRecordMapper.selectByExample(appointmentRecordExample);
            if(appointmentRecords.size()>0){
                int i=1;
                for (AppointmentRecord appointmentrecord:appointmentRecords
                     ) {
                    JSONObject jsonObject=new JSONObject();
                    jsonObject.put("showId",utils.ridToShowId(appointmentrecord.getRid()));
                    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String status=utils.statusToString(appointmentrecord.getArstatus());
                    jsonObject.put("date",simpleDateFormat.format(appointmentrecord.getReqdate()));
                    jsonObject.put("status",status);
                    jsonArray.put(jsonObject);
                    if(i>11)break;
                    i++;
                }
            }else {
                code=-1;
            }
        }else{
            code=0;
        }
        return "{\"code\":"+code+",\"historyList\":"+jsonArray+",\"uname\":\""+uname+"\",\"uprofile\":\""+uprofile+"\"}";
    }

    @Override
    public String showAppointment(HttpServletRequest httpServletRequest) {
        HttpSession httpSession=httpServletRequest.getSession();
        int code=0;
        int arr=0;
        String uname="未登录";
        String uprofile="未登录";
        JSONArray jsonArray=new JSONArray();
        if(utils.isUserLogin(httpServletRequest)){
            int uid=(int)httpSession.getAttribute("uid");
            StUser stUser=stUserMapper.selectByPrimaryKey(uid);
            uname=stUser.getUname();
            uprofile=stUser.getUprofile();
            code=1;
            AppointmentRecordExample appointmentRecordExample=new AppointmentRecordExample();
            appointmentRecordExample.createCriteria().andUidEqualTo((int)httpSession.getAttribute("uid")).andArstatusIn(utils.activeStatus());
            appointmentRecordExample.setOrderByClause("reqdate desc");
            List<AppointmentRecord> appointmentRecords=appointmentRecordMapper.selectByExample(appointmentRecordExample);
            if(appointmentRecords.size()>0){
                for (AppointmentRecord a:appointmentRecords
                     ) {
                    JSONObject jsonObject=new JSONObject();
                    jsonObject.put("showId",utils.ridToShowId(a.getRid()));
                    if(a.getCid()!=null){
                        jsonObject.put("cid",utils.cidToShowId(a.getCid())+"号机");
                    }else{
                        jsonObject.put("cid","预约机房");
                    }
                    jsonObject.put("status",a.getArstatus());
                    jsonObject.put("realRid",a.getRid());
                    jsonObject.put("realCid",a.getCid());
                    jsonArray.put(jsonObject);
                }
                arr=1;
            }
            else {
                arr=0;
            }
        }
        else{
            code=0;
            arr=0;
        }
        return "{\"code\":"+code+",\"uname\":\""+uname+"\",\"uprofile\":\""+uprofile+"\",\"appointmentList\":"+jsonArray+"}";
    }
}
