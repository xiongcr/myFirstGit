package com.myspringtest.test.business.service.impl;

import com.myspringtest.test.business.mapper.UserTestMapper;
import com.myspringtest.test.business.model.UserTest;
import com.myspringtest.test.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserTestMapper userTestMapper;

    @Override
    public int addUser(UserTest user) {
        return userTestMapper.insertSelective(user);
    }

    @Override
    public List<UserTest> findAllUser(int pageNum, int pageSize) {
        return userTestMapper.selectAll();
    }
}
