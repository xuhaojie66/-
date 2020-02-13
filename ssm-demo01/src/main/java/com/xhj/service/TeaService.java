package com.xhj.service;

import com.xhj.po.Teacher;
import com.xhj.vo.Page;

import java.util.List;

public interface TeaService {
    //查找全部老师
    public List<Teacher> findTeas(Page page);
    //查询单个老师信息（用于修改）
    public Teacher findTeaById(int id);
    //通过姓名查询老师信息
    public Teacher findOneByName(String tname);
    //修改老师信息
    public boolean updateTea(Teacher teacher);
    //删除单个老师
    public boolean deleteTea(int id);
    //批量添加老师（service层生成老师的教职工号）
    public boolean addTeas(List<Teacher> teachers);
    //批量删除老师
    public boolean deleteTeas(List<Integer> tids);
    //根据老师id，查询老师的学生
    public Teacher findStuById(Page page,int id);
    //找到当年老师的最大编号(用于生成老师的教职工号)
    public String findMaxNo();
    //查询老师所有学生的班级
    public List<String> findClasses(int id);
    //根据班级，查询老师的学生
    public Teacher findStus(Page page, String sclass,String sname,int id);
    //总行数
    public Integer getRowCount();
}
