package com.xhj.service;


import java.util.List;

public interface GraService {
    //根据老师id，删除数据
    public boolean deleteByTid(int tid);
    //根据老师id，批量删除数据
    public boolean deleteByTids(List<Integer> tids);
    //通过添加班级，批量给老师添加学生
    public boolean insertStus(int tid,List<Integer> sids);
    //通过删除班级，批量给老师删除学生
    public boolean deleteStus(int tid,List<Integer> sids);
}
