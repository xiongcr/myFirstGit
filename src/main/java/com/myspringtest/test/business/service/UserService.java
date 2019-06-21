package com.myspringtest.test.business.service;

import com.myspringtest.test.business.model.UserTest;

import java.util.List;

/**
 * @author xcr
 */
public interface UserService {

    /**
     * fetch data by user
     * @param user 
     * @return int
     */
    int addUser(UserTest user);

    /**
     * query userList
     * @param pageNum
     * @param pageSize
     * @return List
     */
    List<UserTest> findAllUser(int pageNum, int pageSize);
}
