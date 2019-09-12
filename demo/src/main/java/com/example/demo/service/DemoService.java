package com.example.demo.service;

import com.example.demo.pojo.Demo;
import com.example.demo.dao.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

    @Autowired DemoDao demoDao;

    public List<Demo> getAll(){
        return demoDao.getAll();
    }

    public Demo getDemoById(int id){
        return demoDao.getDemoById(id);
    }

    public int insertDemo(Demo demo){
        return demoDao.insertDemo(demo);
    }

    public int updateDemo(Demo demo){
        return demoDao.updateDemo(demo);
    }

    public int deleteDemo(int id){
        return demoDao.deleteDemoById(id);
    }
}
