package com.myspringtest.test.studyTest;

import com.myspringtest.test.studyTest.thread.InterruptThread;

/**
 * @author xcr
 */
public class Demo2 {

    public static void main(String [] args)throws Exception{

        InterruptThread interruptThread=new InterruptThread();
        interruptThread.start();

        Thread.sleep(1000);
        interruptThread.isInterrupted();
        while (interruptThread.isAlive()) {
        }

        }
}
