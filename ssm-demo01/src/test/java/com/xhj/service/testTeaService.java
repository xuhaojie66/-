package com.xhj.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testTeaService {
    private ApplicationContext ac = null;
    @Before
    public void setup(){
        ac = new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
    }
    @Test
    public void testMethod1(){
        TeaService teaService = ac.getBean(TeaService.class);
        String maxNo = teaService.findMaxNo();
        int i;
        if (maxNo==null||maxNo=="") i=1;
        else i=Integer.parseInt(maxNo.substring(maxNo.length()-3))+1;
        for (int j=0;j<10;j++,i++){
            StringBuffer s = new StringBuffer(maxNo.substring(0,maxNo.length()-3));
            s.append(String.format("%03d",i));
            System.out.println(s.toString());
        }
    }
    @Test
    public void testMethod2(){
        TeaService teaService = ac.getBean(TeaService.class);
        int i=0;
       teaService.findTeaById(i);
    }
}
