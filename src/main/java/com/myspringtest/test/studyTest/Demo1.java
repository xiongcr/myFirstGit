package com.myspringtest.test.studyTest;

import com.sun.javafx.UnmodifiableArrayList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Function;

/**
 * @author xcr
 */
public class Demo1 {

    public static void main(String [] args){

     //传统写法
        PropertyChangeListener p=new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
               evt.getNewValue();
            }
        };
        //简约写法
       PropertyChangeListener propertyChangeListener=evt -> {

       };

       //及其简单
        Function<String,String>  a=Demo1::compareTo;

        //writableStackTrace控制方法开销


//        Collections arrayListArrayListCollections = new Collections<>();
//        Cloneable
//        ThreadLocal
    }

    private static String compareTo(String s) {
        return null;
    }


}
