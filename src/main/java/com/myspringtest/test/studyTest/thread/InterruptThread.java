package com.myspringtest.test.studyTest.thread;

public class InterruptThread extends  Thread {
    private int i=0,j=0;

    @Override
    public void run() {
        synchronized(this){
         ++i;
         try{
        Thread.sleep(10000);
         }catch (Exception e){

         }
         ++j;
        }
    }
}
