package com.example.demo.controller;

import com.example.demo.error.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThController {

    @RequestMapping("/")
    public String indexDefault(ModelMap map){
        map.addAttribute("host","http://baidu.com");
        return "index";
    }

    @RequestMapping("/errorJson")
    public String errorJson() throws MyException{
        throw new MyException("发生错误");
    }


}
