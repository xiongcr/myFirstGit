package com.myspringtest.test;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * @author xcr
@MapperScan仅扫描业务接口包，不能扫描本地通用Mapper接口包，
  否则报java.lang.ClassCastException: sun.reflect.generics.reflectiveObjects.TypeVariableImpl
        cannot be cast to java.lang.Class异常
 mapperscan导包有问题
**/
@SpringBootApplication
@MapperScan(basePackages = "com.myspringtest.test.business.mapper")
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

}
