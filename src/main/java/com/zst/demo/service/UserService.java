package com.zst.demo.service;

import com.zst.demo.dao.UserMapper;
import com.zst.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    /*
    * 添加用户
    * @Param recode 用户记录集合
    * */
    public String addUser(User recode){
        recode.setCreatedBy(Long.valueOf(1));
        recode.setCreationDate(new Date());
        userMapper.insert(recode);
        return "1";
    }

    /*
    * 通过id删除用户
    * @Param id 用户id
    * */
    public String deleteUserById(String id){
        userMapper.deleteByPrimaryKey(Long.valueOf(id));
        return "1";
    }
}
