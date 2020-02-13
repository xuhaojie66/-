package com.xhj.controller;

import com.xhj.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/student")
public class StuController {
    @Autowired
    private StuService stuService;

}
