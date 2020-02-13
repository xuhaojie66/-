package com.xhj.service.impl;

import com.xhj.mapper.StuMapper;
import com.xhj.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuServiceImpl implements StuService {
    @Autowired
    private StuMapper stuMapper;

}
