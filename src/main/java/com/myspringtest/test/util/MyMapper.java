package com.myspringtest.test.util;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
/**
* @author xcr
* */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
