package com.kang.computer_room_management.common.domain;

public class Admin {
    private Integer aid;

    private String aname;

    private String apsswd;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname == null ? null : aname.trim();
    }

    public String getApsswd() {
        return apsswd;
    }

    public void setApsswd(String apsswd) {
        this.apsswd = apsswd == null ? null : apsswd.trim();
    }
}