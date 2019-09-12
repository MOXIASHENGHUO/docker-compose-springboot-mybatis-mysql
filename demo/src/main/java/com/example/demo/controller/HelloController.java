package com.example.demo.controller;

import com.example.demo.pojo.Demo;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/hello")
    public String index(){
        return "Hello world!";
    }

    @RequestMapping("/getAll")
    public List<Demo> getAll(){
        List<Demo> demoList = demoService.getAll();
        return demoList;
    }

    @GetMapping("/find")
    public Demo getDemoById(@RequestParam("id") int id){
        return demoService.getDemoById(id);
    }

    @PutMapping("/insert")
    public int insertDemo(@RequestBody Demo demo){
        int result = demoService.insertDemo(demo);
        return result;
    }

    @PostMapping("/update")
    public int updateDemo(@RequestBody Demo demo){
        int result = demoService.updateDemo(demo);
        return result;
    }

    @DeleteMapping("/delete")
    public int deleteDemo(@RequestParam("id") int id){
        return demoService.deleteDemo(id);
    }
}
