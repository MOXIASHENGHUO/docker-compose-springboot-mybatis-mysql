package com.example.demo.controller;

import com.example.demo.error.MyException;
import com.example.demo.pojo.Demo;
import com.example.demo.pojo.User;
import com.example.demo.service.DemoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private DemoService demoService;

    @ApiOperation(value = "hello world")
    @GetMapping("/hello")
    public String index(){
        return "Hello world!";
    }

    @ApiOperation(value = "获取所有数据对象")
    @GetMapping("/getAll")
    public List<Demo> getAll(){
        List<Demo> demoList = demoService.getAll();
        return demoList;
    }

    @ApiOperation(value = "获取数据对象",notes = "根据url的id来获取数据对象")
    @ApiImplicitParam(name = "id",value = "DemoID",required = true,dataType = "int")
    @GetMapping("/find")
    public Demo getDemoById(@RequestParam("id") int id){
        return demoService.getDemoById(id);
    }

    @ApiOperation(value = "插入数据对象",notes = "根据Demo对象来插入数据")
    @ApiImplicitParam(name = "Demo",value = "Demo实体",required = true,dataType = "Demo")
    @PostMapping("/insert")
    public int insertDemo(@RequestBody Demo demo){
        int result = demoService.insertDemo(demo);
        return result;
    }

    @ApiOperation(value = "更新数据",notes = "根据Demo对象来更新数据")
    @ApiImplicitParam(name = "Demo",value = "Demo实体",required = true,dataType = "Demo")
    @PutMapping("/update")
    public int updateDemo(@RequestBody Demo demo){
        int result = demoService.updateDemo(demo);
        return result;
    }

    @ApiOperation(value = "删除数据",notes = "根据DemoID删除数据对象")
    @ApiImplicitParam(name = "id",value = "DemoID",required = true,dataType = "int")
    @DeleteMapping("/delete")
    public int deleteDemo(@RequestParam("id") int id){
        return demoService.deleteDemo(id);
    }

    @ApiOperation(value = "添加User数据",notes = "添加User对象")
    @ApiImplicitParam(name = "User",value = "User实体",required = true,dataType = "User")
    @PostMapping(value = "/user",consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE)
    public User create(@RequestBody User user){
        user.setName("test:"+user.getName());
        user.setAge(user.getAge()+1);
        return user;
    }

}
