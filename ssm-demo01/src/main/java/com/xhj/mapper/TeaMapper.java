package com.xhj.mapper;

import com.xhj.po.Teacher;
import com.xhj.vo.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeaMapper {
    //查找全部老师
    public List<Teacher> findAll(@Param("page") Page page);
    //查询单个老师信息（用于修改）
    public Teacher findOneById(@Param("id") int id);
    //通过姓名查询老师信息
    public Teacher findOneByName(@Param("tname") String tname);
    //修改老师信息
    public void updateOne(@Param("teacher") Teacher teacher);
    //删除单个老师
    public void deleteOne(@Param("id") int id);
    //批量添加老师
    public void insertTeas(@Param("teachers") List<Teacher> teachers);
    //批量删除老师
    public void deleteTeas(@Param("tids") List<Integer> tids);

    //找到当年老师的最大编号(用于生成老师的教职工号)
    public String findMaxNo(@Param("tno") String no);
    //查询老师所有学生的班级
    public List<String> findClasses(@Param("tid") int id);
    //根据老师id，查询老师的学生
    //根据班级，查询老师的学生
    public Teacher findStus(@Param("page") Page page,@Param("sclass") String sclass,@Param("sname") String sname,@Param("tid") int id);
    //总行数
    public Integer getRowCount();
}
