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
 * <p>
 * 03/15
 * GetMapping("/hello")
 * public String hello(@RequestParam(name = "name") String name , Model model){
 * model.addAttribute("name",name);
 * return "index";
 * }
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        //有个bug，若用户清空cookie再登录呢,需要加一个cookie判断
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0)
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        return "index";
    }
}
