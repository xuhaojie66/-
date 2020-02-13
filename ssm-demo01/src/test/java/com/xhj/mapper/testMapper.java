package com.xhj.mapper;

import com.xhj.po.Teacher;
import com.xhj.vo.Page;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class testMapper {
    private ApplicationContext ac = null;
    @Before
    public void setup(){
        ac = new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
    }
    @Test
    public void testTeaMethod1(){
        TeaMapper teaMapper = ac.getBean(TeaMapper.class);
        Teacher teacher = new Teacher();
        teacher.setTid(1);
        teacher.setTname("称老师");
        teacher.setTsex("女");
        System.out.println(teacher);
        teaMapper.updateOne(teacher);
        System.out.println("ok");
    }
//    @Test
//    public void testTeaMethod2(){
//        TeaMapper teaMapper = ac.getBean(TeaMapper.class);
//        Teacher stuById = teaMapper.findStuById(1);
//        System.out.println(stuById);
//    }
    @Test
    public void testTeaMethod3(){
        TeaMapper teaMapper = ac.getBean(TeaMapper.class);
        Page page = new Page();
        page.setPageNow(1);
        page.setPageSize(3);
        List<Teacher> all = teaMapper.findAll(page);
        System.out.println(all);
    }

}
