package com.kang.computer_room_management.common.domain;

import java.util.Date;

public class AppointmentRecord {
    private Date reqdate;

    private Integer uid;

    private Integer rid;

    private Integer arstatus;

    private Date dealdate;

    private Integer artype;

    private Integer cid;

    public Date getReqdate() {
        return reqdate;
    }

    public void setReqdate(Date reqdate) {
        this.reqdate = reqdate;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getArstatus() {
        return arstatus;
    }

    public void setArstatus(Integer arstatus) {
        this.arstatus = arstatus;
    }

    public Date getDealdate() {
        return dealdate;
    }

    public void setDealdate(Date dealdate) {
        this.dealdate = dealdate;
    }

    public Integer getArtype() {
        return artype;
    }

    public void setArtype(Integer artype) {
        this.artype = artype;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}