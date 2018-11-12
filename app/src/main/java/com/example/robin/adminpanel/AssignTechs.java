package com.example.robin.adminpanel;

public class AssignTechs {
    private String tid;
    private String Tname;
    private String status;
    private String cid;

    public AssignTechs(String Tname, String status,String cid,String tid) {
        this.Tname = Tname;
        this.status= status;
        this.cid = cid;
        this.tid = tid;
    }

    public String getCid() {
        return cid;
    }

    public String getTname() {
        return Tname;
    }

    public String getStatus() {
        return status;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }
}
