package com.xhj.service.impl;

import com.xhj.mapper.GraMapper;
import com.xhj.service.GraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraServiceImpl implements GraService {
    @Autowired
    private GraMapper graMapper;

    @Override
    public boolean deleteByTid(int tid) {
        try {
            graMapper.deleteByTid(tid);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteByTids(List<Integer> tids) {
        try {
            graMapper.deleteByTids(tids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean insertStus(int tid, List<Integer> sids) {
        try {
            graMapper.insertStus(tid,sids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteStus(int tid, List<Integer> sids) {
        try {
            graMapper.deleteStus(tid,sids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
