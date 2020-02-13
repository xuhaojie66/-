package com.xhj.po;

import java.io.Serializable;

public class Grade implements Serializable {
    private int gid;
    private int ctid;
    private int csid;

    @Override
    public String toString() {
        return "Grade{" +
                "gid=" + gid +
                ", ctid=" + ctid +
                ", csid=" + csid +
                '}';
    }

    public Grade() {
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getCtid() {
        return ctid;
    }

    public void setCtid(int ctid) {
        this.ctid = ctid;
    }

    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }
}
