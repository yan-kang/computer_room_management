package com.kang.computer_room_management.service;

import com.kang.computer_room_management.common.Utils;
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
    Utils utils=new Utils();
    final private StUserMapper stUserMapper;
    final private IAdminService adminService;
    @Autowired
    public UserService(StUserMapper stUserMapper, IAdminService adminService) {
        this.stUserMapper = stUserMapper;
        this.adminService = adminService;
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
                        if (stUserInDb.getUpsswd().equals(utils.toMd5HashString(stUser.getUpsswd()))) {
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
                        if (adminInDb.getApsswd().equals(utils.toMd5HashString(admin.getApsswd()))) {
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
        if (!httpServletRequest.getParameter("uname").equals("")) {
            String msg = "";
            int a;
            StUser stUser = new StUser();
            stUser.setUname(httpServletRequest.getParameter("uname"));
            if (login(stUser) == null) {
                stUser.setUpsswd(utils.toMd5HashString(httpServletRequest.getParameter("upsswd")));
                stUser.setUprofile("这个人很懒，什么都没写哦");
                stUserMapper.insert(stUser);
                httpSession.setAttribute("uname", stUser.getUname());
                httpSession.setAttribute("uid", login(stUser).getUid());
                httpSession.setAttribute("type", "user");
                httpSession.setMaxInactiveInterval(600);
                model.addAttribute("uname", stUser.getUname());
                model.addAttribute("uprofile", stUser.getUprofile());
                a=1;
            }
            else {
                msg = "用户名已存在!";
                a=0;
            }
            model.addAttribute("msg", msg);
            return "{\"code\":"+a+",\"msg\":\""+msg+"\"}";
        }
        else{
            return "redirect:/register";
        }
    }

    @Override
    public String resetInfo(HttpServletRequest httpServletRequest) {
        HttpSession httpSession=httpServletRequest.getSession();
        int code;
        if(utils.isUserLogin(httpServletRequest)){
            String upsswd=httpServletRequest.getParameter("upsswd");
            StUser stUser=new StUser();
            stUser.setUid((int)(httpSession.getAttribute("uid")));
            if(upsswd.equals("")){
                stUser.setUprofile(httpServletRequest.getParameter("uprofile"));
                code=1;
                stUserMapper.updateByPrimaryKeySelective(stUser);
            }else {
                if(utils.toMd5HashString(upsswd).equals(stUserMapper.selectByPrimaryKey((int)(httpSession.getAttribute("uid"))).getUpsswd())){
                    if(!httpServletRequest.getParameter("uprofile").equals("")){
                        stUser.setUprofile(httpServletRequest.getParameter("uprofile"));
                    }
                    stUser.setUpsswd(utils.toMd5HashString(httpServletRequest.getParameter("newPsswd")));
                    code=1;
                    stUserMapper.updateByPrimaryKeySelective(stUser);
                }else {
                    code=0;
                }
            }
        }else{
            code=-1;
        }
        return "{\"code\":"+code+"}";
    }

}
