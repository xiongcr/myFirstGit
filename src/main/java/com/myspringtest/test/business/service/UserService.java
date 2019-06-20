package com.myspringtest.test.business.service;

import com.myspringtest.test.business.model.UserTest;

import java.util.List;

public interface UserService {

    int addUser(UserTest user);

    List<UserTest> findAllUser(int pageNum, int pageSize);
}
