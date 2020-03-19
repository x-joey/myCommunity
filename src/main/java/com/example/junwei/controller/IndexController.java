package com.example.junwei.controller;

import com.example.junwei.mapper.UserMapper;
import com.example.junwei.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

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

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request){
        Cookie[] cookies =  request.getCookies();
        for (Cookie cookie :cookies){
            if (cookie.getName().equals("token")){
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if (user != null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        return "index";
    }
}
