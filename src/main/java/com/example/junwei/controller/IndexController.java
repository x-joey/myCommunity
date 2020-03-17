package com.example.junwei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * create by junwei on 2020/03/16
 *
 * 03/15
 *    GetMapping("/hello")
 *     public String hello(@RequestParam(name = "name") String name , Model model){
 *         model.addAttribute("name",name);
 *         return "index";
 *     }
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
