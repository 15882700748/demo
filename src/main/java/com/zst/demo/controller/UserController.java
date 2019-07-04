package com.zst.demo.controller;

import com.zst.demo.entity.User;
import com.zst.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/*
*@auth zst
* user controller
* */
@Controller
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(User recode){
        return userService.addUser(recode);
    }

    @RequestMapping("/deleteUserById")
    @ResponseBody
    public String deleteBillById(String id){

        return userService.deleteUserById(id);
    }
}
