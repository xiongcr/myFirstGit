package com.myspringtest.test.studyTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xcr
 */
public class Demo1 {

    public static void main(String [] args){

     //传统写法
//        PropertyChangeListener p=new PropertyChangeListener() {
//            @Override
//            public void propertyChange(PropertyChangeEvent evt) {
//               evt.getNewValue();
//            }
//        };
//        //简约写法
//       PropertyChangeListener propertyChangeListener=evt -> {
//
//       };
//
//       //及其简单
//        Function<String,String>  a=Demo1::compareTo;

        //writableStackTrace控制方法开销


//        Collections arrayListArrayListCollections = new Collections<>();
//        Cloneable
//        ThreadLocal


        System.out.println(dayOfYear("2019-01-29"));



    }

    public static int dayOfYear(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String edate = date.substring(0, 4) + "-01-01";
        Date startTime =new Date(),endTime=new Date();
        try {
            startTime = sdf.parse(date);
            endTime = sdf.parse(edate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long time = startTime.getTime() - endTime.getTime();
        System.out.println(time);
        int days = (int) time / (60 * 60 * 24 * 1000);
        return days;
    }

    private static String compareTo(String s) {
        return null;
    }

    private String test(){
        return null;
    }


}
