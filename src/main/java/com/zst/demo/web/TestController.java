package com.zst.demo.web;

import com.zst.demo.dao.UserMapper;
import com.zst.demo.entity.User;
import com.zst.demo.utils.RedisBaiseTakes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisBaiseTakes redisBaiseTakes;

    @RequestMapping("/test")
    @ResponseBody
    public List<User> getUserTest(User user){
        return userMapper.getUsers(user);
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String test(String word){
        return word+",hello";
    }






}
