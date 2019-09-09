package com.myspringtest.test.studyTest;

import java.sql.SQLOutput;
import java.util.*;

/**
 * @author xcr
 */
public class ListRemoveDemo {
    public static void main(String[] args) {
        List<Map<String,String>> allList=new ArrayList<>();
        for (int i=0;i<10;i++)
        {
            Map map=new HashMap();
            map.put("Ni","111");
            map.put("num",i);
            allList.add(map);
        }
        Iterator iterator=allList.iterator();
        while (iterator.hasNext()){
            Map m= (Map) iterator.next();
            if(Integer.parseInt(String.valueOf(m.get("num")))==4){
                iterator.remove();
            }
        }
        for (Map map:allList){
            System.out.println(map.get("num"));
        }


    }


}
