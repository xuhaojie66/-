package com.xhj.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GraMapper {
    //根据老师id，删除数据
    public void deleteByTid(@Param("tid") int tid);
    //根据老师id，批量删除数据
    public void deleteByTids(@Param("tids") List<Integer> tids);
    //通过添加班级，批量给老师添加学生
    public void insertStus(@Param("tid") int tid,@Param("sids") List<Integer> sids);
    //通过删除班级，批量给老师删除学生
    public void deleteStus(@Param("tid") int tid,@Param("sids") List<Integer> sids);
}
