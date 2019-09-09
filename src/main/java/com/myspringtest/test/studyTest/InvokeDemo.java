package com.myspringtest.test.studyTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author xcr
 */
public class InvokeDemo {



    public static void main(String[] args) {
        String path = "com.myspringtest.test.studyTest.Demo1";
        try {
            Class clazz= Class.forName(path);
            Field[] field02 = clazz.getDeclaredFields();
            Method method = clazz.getDeclaredMethod("test", null);
            System.out.printf(field02.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }




}
