package com.zst.demo.dao;

import com.zst.demo.annotation.MyBatis;
import com.zst.demo.entity.User;

import java.util.List;

@MyBatis
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User>  getUsers(User user);
}