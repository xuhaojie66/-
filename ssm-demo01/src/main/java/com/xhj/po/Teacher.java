package com.xhj.po;

import java.io.Serializable;
import java.util.List;

public class Teacher implements Serializable {
    private int tid;
    private String tno;
    private String tname;
    private String tsex;
    private List<Student> students;

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                ", tsex='" + tsex + '\'' +
                ", students=" + students +
                '}';
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }
}
