package com.xhj.controller;

import com.xhj.po.Student;
import com.xhj.po.Teacher;
import com.xhj.service.GraService;
import com.xhj.service.TeaService;
import com.xhj.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeaController {
    @Autowired
    private TeaService teaService;
    @Autowired
    private GraService graService;

    /**
     * 查找全部老师
     * @return List<Teacher>
     */
    @RequestMapping(value = "/teachers" ,method = {RequestMethod.GET,RequestMethod.POST})
    public String findAll(@RequestParam(value = "page",required = false) Page page,Model model){
        if(page==null){
            page = new Page();
            page.setPageNow(1);
        }
        page.setPageSize(10);
        page.setRowCount(teaService.getRowCount());
        List<Teacher> teas = teaService.findTeas(page);
        model.addAttribute("teachers",teas);
        model.addAttribute("page",page);
        return "list";
    }

    /**
     * 查询单个老师信息（用于修改）
     * @param id
     * @param model
     * @return Teacher
     */
    @RequestMapping(value = "/selectOneById", method = {RequestMethod.GET,RequestMethod.POST})
    public String findOneById(@RequestParam("tid") int id,Model model){
        Teacher teacher = teaService.findTeaById(id);
        model.addAttribute("teacher",teacher);
        return "edit";
    }

    /**
     * 通过姓名查询老师信息
     * @param tname
     * @param model
     * @return
     */
    @RequestMapping(value = "/selectOneByName", method = {RequestMethod.GET,RequestMethod.POST})
    public String findOneByName(@RequestParam("tname") String tname,Model model){
        Teacher teacher = teaService.findOneByName(tname);
        model.addAttribute("teachers",teacher);
        return "list";
    }
    /**
     * 修改老师信息
     * @param teacher
     * @return 返回主页面
     */
    @RequestMapping(value = "/modify",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateOne(@RequestParam("teacher") Teacher teacher){
        boolean b = teaService.updateTea(teacher);
        if(b){
            return "redirect:/teacher/teachers";
        }
        return null;
    }

    /**
     * 删除单个老师
     * @param id
     * @return 返回主页面
     */
    @RequestMapping(value = "/deleteOne",method = {RequestMethod.GET,RequestMethod.POST})
    public String deleteOne(@RequestParam("tid") int id){
        boolean b = teaService.deleteTea(id);
        boolean b1 = graService.deleteByTid(id);
        if(b && b1){
            return "redirect:/teacher/teachers";
        }
        return null;
    }

    /**
     * 批量添加老师（service层生成老师的教职工号）
     * @param teachers
     * @return 返回主页面
     */
    @RequestMapping(value = "/addTeas",method = {RequestMethod.GET,RequestMethod.POST},
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String addTeas(@RequestBody List<Teacher> teachers){
        boolean b = teaService.addTeas(teachers);
        if(b){
            return "redirect:/teacher/teachers";
        }
        return "redirect:/teacher/teachers";
    }

    /**
     * 批量删除老师
     * @param tids
     * @return 返回主页面
     */
    @RequestMapping(value = "/deleteTeas",method = {RequestMethod.GET,RequestMethod.POST},
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String deleteTeas(@RequestBody List<Integer> tids){
        boolean b = teaService.deleteTeas(tids);
        boolean b1 = graService.deleteByTids(tids);
        if(b && b1){
            return "redirect:/teacher/teachers";
        }
        return "redirect:/teacher/teachers";
    }
    /**
     * 根据老师id，查询老师的学生，和学生所在的班级
     * @param tid
     * @param model
     * @return 返回老师页面
     */
    @RequestMapping(value = "/selectStuById",method = {RequestMethod.GET,RequestMethod.POST})
    public String findStus(@RequestParam(value = "page",required = false) Page page,@RequestParam("tid") int tid, Model model){
        if(page==null){
            page = new Page();
            page.setPageNow(1);
        }
        page.setPageSize(10);
        page.setRowCount(teaService.getRowCount());
        Teacher teacher = teaService.findStuById(page,tid);
        model.addAttribute("teacher",teacher);
        model.addAttribute("students",teacher.getStudents());
        List<String> classes = teaService.findClasses(tid);
        model.addAttribute("classes",classes);
        model.addAttribute("page",page);
        return "students";
    }

    /**
     * 根据老师id和(班级||学生姓名||班级+学生姓名)，查询老师的学生
     * @param sclass
     * @param tid
     * @param model
     * @return 老师的学生界面
     */
    @RequestMapping(value = "/selectStuByClass",method = {RequestMethod.GET,RequestMethod.POST})
    public String findStusByClass(@RequestParam(value = "page",required = false) Page page,
                                  @RequestParam("tid") int tid,@RequestParam("sclass") String sclass,
                                  @RequestParam("sname") String sname, Model model){
        if(page==null){
            page = new Page();
            page.setPageNow(1);
        }
        page.setPageSize(10);
        page.setRowCount(teaService.getRowCount());
        Teacher teacher = teaService.findStus(page,sclass,sname,tid);
        model.addAttribute("teacher",teacher);
        model.addAttribute("students",teacher.getStudents());
        return "students";
    }

    /**
     * 老师根据班级批量添加学生
     * @param tid
     * @param sclass
     * @param model
     * @return 老师的学生界面
     */
    @RequestMapping(value = "/insertStus",method = {RequestMethod.GET,RequestMethod.POST})
    public String addStus(@RequestParam("tid") int tid,@RequestParam("sclass") String sclass,
                          Model model){
        String sname=null;
        Integer tid1=null;
        Page page = null;
        List<Student> students = teaService.findStus(page,sclass, sname, tid1).getStudents();
        List<Integer> sids = new ArrayList<>();
        for (int i=0;i<sids.size();i++)
        {
            sids.add(students.get(i).getSid());
        }
        boolean b = graService.insertStus(tid, sids);
        model.addAttribute("tid",tid);
        model.addAttribute("sclass",sclass);
        if(b){
            return "redirect:/teacher/selectStuByClass";
        }
        return "redirect:/teacher/selectStuByClass";
    }

    /**
     * 老师根据班级批量删除学生
     * @param tid
     * @param sclass
     * @param model
     * @return 老师的学生界面
     */
    @RequestMapping(value = "/deleteStus",method = {RequestMethod.GET,RequestMethod.POST})
    public String deleteStus(@RequestParam("tid") int tid,@RequestParam("sclass") String sclass,
                          Model model){
        String sname=null;
        Integer tid1=null;
        Page page = null;
        List<Student> students = teaService.findStus(page,sclass, sname, tid1).getStudents();
        List<Integer> sids = new ArrayList<>();
        for (int i=0;i<sids.size();i++)
        {
            sids.add(students.get(i).getSid());
        }
        boolean b = graService.deleteStus(tid, sids);
        model.addAttribute("tid",tid);
        model.addAttribute("sclass",sclass);
        if(b){
            return "redirect:/teacher/selectStuByClass";
        }
        return "redirect:/teacher/selectStuByClass";
    }
}
