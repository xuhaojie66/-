package com.xhj.service.impl;

import com.xhj.mapper.TeaMapper;
import com.xhj.po.Teacher;
import com.xhj.service.TeaService;
import com.xhj.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class TeaServiceImpl implements TeaService {

    //注入dao对象
    @Autowired
    private TeaMapper teaMapper;
    @Override
    public List<Teacher> findTeas(Page page) {
        List<Teacher> all = teaMapper.findAll(page);
        return all;
    }

    @Override
    public Teacher findTeaById(int id) {
        Teacher teacher = teaMapper.findOneById(id);
        return teacher;
    }

    @Override
    public Teacher findOneByName(String tname) {
        Teacher teacher = teaMapper.findOneByName(tname);
        return teacher;
    }

    @Override
    public boolean updateTea(Teacher teacher) {
        try {
            teaMapper.updateOne(teacher);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteTea(int id) {
        try {
            teaMapper.deleteOne(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addTeas(List<Teacher> teachers) {
        try {
            String maxNo = this.findMaxNo();
            int i;
            if (maxNo==null||maxNo=="") i=1;
            else i=Integer.parseInt(maxNo.substring(maxNo.length()-3))+1;
            for (int j=0;j<teachers.size();j++,i++){
                StringBuffer s = new StringBuffer(maxNo.substring(0,maxNo.length()-3));
                s.append(String.format("%03d",i));
                teachers.get(j).setTno(s.toString());
            }
            teaMapper.insertTeas(teachers);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteTeas(List<Integer> tids) {
        try {
            teaMapper.deleteTeas(tids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Teacher findStuById(Page page,int id) {
        String sclass = null;
        String sname = null;
        Teacher teacher = teaMapper.findStus(page,sclass,sname,id);
        return teacher;
    }

    @Override
    public String findMaxNo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String s = sdf.format(date);
        String maxNo = teaMapper.findMaxNo(s);
        return maxNo;
    }

    @Override
    public List<String> findClasses(int id) {
        List<String> classes = teaMapper.findClasses(id);
        return classes;
    }

    @Override
    public Teacher findStus(Page page,String sclass,String sname, int id) {
        Teacher teacher = teaMapper.findStus(page,sclass,sname, id);
        return teacher;
    }

    @Override
    public Integer getRowCount() {
        Integer rowCount = teaMapper.getRowCount();
        return rowCount;
    }
}
