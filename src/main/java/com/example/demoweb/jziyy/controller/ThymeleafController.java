package com.example.demoweb.jziyy.controller;

import com.example.demoweb.jziyy.bean.Userinfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/jziyy")
public class ThymeleafController {


    @RequestMapping(value = "/demo")
    public String getData(Model model){
        Userinfo userinfo = new Userinfo();
        userinfo.setAge(24);
        userinfo.setName("jz");
        userinfo.setPassword("jziyy");
        model.addAttribute("user",userinfo);
        return "Template";
    }

    @RequestMapping(value = "/success")
    public String goToSuccess(Model model){
        model.addAttribute("one","jz");
        model.addAttribute("two","yy");

    return "Success";
    }
}
