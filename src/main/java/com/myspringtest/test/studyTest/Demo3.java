package com.myspringtest.test.studyTest;

import java.util.*;

/**
* @author xcr
* 带权重抽奖代码
* */
public class Demo3 {

    public static void main(String[] args) {



    }


    public int lotter(Map<String,String> maps, List<String> keyList,int sum ,int count){
        //判断id ，如果有就放弃
        if(keyList.contains(maps.get("id"))){
            return 0;
        }
        keyList.add(maps.get("id"));
        int numWeight= Integer.parseInt(maps.get("numWeight"));
        int sumValue=0;
        for(String key:maps.keySet()){
            sumValue=sumValue+Integer.parseInt(maps.get(key));
        }
        int randomNum= (int) (Math.random()*1000000);
        if(randomNum*(numWeight/sumValue)<sum/maps.size()&&count<maps.size()){
            count++;
            return 1;
        }
         return 0;
       }





}
