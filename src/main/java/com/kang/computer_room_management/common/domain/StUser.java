package com.kang.computer_room_management.common.domain;

public class StUser {
    private Integer uid;

    private String uname;

    private String upsswd;

    private String uprofile;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUpsswd() {
        return upsswd;
    }

    public void setUpsswd(String upsswd) {
        this.upsswd = upsswd == null ? null : upsswd.trim();
    }

    public String getUprofile() {
        return uprofile;
    }

    public void setUprofile(String uprofile) {
        this.uprofile = uprofile == null ? null : uprofile.trim();
    }
}