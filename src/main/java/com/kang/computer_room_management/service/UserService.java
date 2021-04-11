package com.kang.computer_room_management.service;

import com.kang.computer_room_management.common.domain.Admin;
import com.kang.computer_room_management.common.domain.StUser;
import com.kang.computer_room_management.common.domain.StUserExample;
import com.kang.computer_room_management.mapper.StUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserService implements IUserService {

    final private StUserMapper stUserMapper;
    final private IAdminService adminService;
    final private ICommonService commonService;
    @Autowired
    public UserService(StUserMapper stUserMapper, IAdminService adminService,ICommonService commonService) {
        this.stUserMapper = stUserMapper;
        this.adminService = adminService;
        this.commonService = commonService;
    }

    @Override
    public StUser login(StUser stUser) {
        //查询传入用户名是否存在
        StUserExample stUserExample=new StUserExample();
        stUserExample.createCriteria().andUnameEqualTo(stUser.getUname());
        List<StUser> userList=stUserMapper.selectByExample(stUserExample);
        return userList.size()>0?userList.get(0):null;
    }

    @Override
    public String loginServer(HttpServletRequest httpServletRequest, Model model) {
        HttpSession httpSession=httpServletRequest.getSession();
        if(httpServletRequest.getParameter("userType")!=null) {
            if (Integer.parseInt(httpServletRequest.getParameter("userType")) == 0) {
                StUser stUser = new StUser();
                stUser.setUname(httpServletRequest.getParameter("uname"));
                stUser.setUpsswd(httpServletRequest.getParameter("upsswd"));
                    //用户登录判断
                    StUser stUserInDb = login(stUser);
                    String msg;
                    boolean success;
                    int errorCode=0;
                    if (stUserInDb == null) {
                        msg = "用户不存在！";
                        errorCode=0;
                        success = false;
                    } else {
                        if (stUserInDb.getUpsswd().equals(stUser.getUpsswd())) {
                            msg = "欢迎你" + stUser.getUname();
                            success = true;
                            httpSession.setAttribute("uname", stUserInDb.getUname());
                            httpSession.setAttribute("uid", stUserInDb.getUid());
                            httpSession.setAttribute("type","user");
                            httpSession.setMaxInactiveInterval(600);
                            model.addAttribute("uname", httpSession.getAttribute("uname"));
                            model.addAttribute("uprofile", stUserInDb.getUprofile());
                        } else {
                            msg = "密码错误！";
                            success = false;
                            errorCode=1;
                        }
                    }

                    Date date = new Date();
                    SimpleDateFormat nowTime = new SimpleDateFormat();
                    nowTime.applyPattern("yyyy-MM-dd HH:mm:ss a");
                    model.addAttribute("date", nowTime.format(date));
                    model.addAttribute("msg", msg);
                    return success ? "{\"code\":\"success\"}" : "{\"error\":\""+msg+"\",\"errorCode\":"+errorCode+"}";
            } else {
                //管理员登录判断
                    Admin admin = new Admin();
                    admin.setAname(httpServletRequest.getParameter("uname"));
                    admin.setApsswd(httpServletRequest.getParameter("upsswd"));
                    Admin adminInDb = adminService.login(admin);
                    String msg = "";
                    int errorCode=0;
                    boolean success;
                    if (adminInDb == null) {
                        msg = "登录名错误！";
                        errorCode=0;
                        success = false;
                    } else {
                        if (adminInDb.getApsswd().equals(admin.getApsswd())) {
                            msg = "欢迎你" + admin.getAname();
                            model.addAttribute("uname", adminInDb.getAname());
                            httpSession.setAttribute("uname", adminInDb.getAname());
                            httpSession.setAttribute("uid", adminInDb.getAid());
                            httpSession.setAttribute("type","admin");
                            httpSession.setMaxInactiveInterval(600);
                            success = true;
                        } else {
                            msg = "密码错误！";
                            errorCode=1;
                            success = false;
                        }
                    }
                    model.addAttribute("msg", msg);
                    return success ? "{\"code\":\"success\",\"admin\":\"yes\"}" : "{\"error\":\""+msg+"\",\"errorCode\":"+errorCode+"}";
            }
        }
        else{
            return "login";
        }
    }

    @Override
    public String register(HttpServletRequest httpServletRequest, Model model) {
        HttpSession httpSession = httpServletRequest.getSession();
        if (httpServletRequest.getParameter("uname") != "") {
            String msg = "";
            boolean success;
            int a=0;
            StUser stUser = new StUser();
            stUser.setUname(httpServletRequest.getParameter("uname"));
            if (login(stUser) == null) {
                stUser.setUpsswd(httpServletRequest.getParameter("upsswd"));
                stUser.setUprofile("这个人很懒，什么都没写哦");
                stUserMapper.insert(stUser);
                httpSession.setAttribute("uname", stUser.getUname());
                httpSession.setAttribute("uid", login(stUser).getUid());
                httpSession.setAttribute("type", "user");
                httpSession.setMaxInactiveInterval(600);
                model.addAttribute("uname", stUser.getUname());
                model.addAttribute("uprofile", stUser.getUprofile());
                success = true;
                a=1;
            }
            else {
                msg = "用户名已存在!";
                success = false;
                a=0;
            }
            model.addAttribute("msg", msg);
            return "{\"code\":"+a+",\"msg\":\""+msg+"\"}";
           // return success ? "{\"code\":\"success\"}" : "{\"error\":\""+msg+"\",\"code\":\"fail\"}";
        }
        else{
            return "redirect:/register";
        }
    }
}
