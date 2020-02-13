package com.xhj.mapper;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testGraMapper {
    private ApplicationContext ac = null;
    @Before
    public void setup(){
        ac = new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
    }


}
