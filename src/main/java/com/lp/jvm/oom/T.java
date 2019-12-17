package com.lp.jvm.oom;

/**
 * @Author: lp
 * @Date： 2019/12/10 10:52
 */
public class T {

    public static void main(String[] args) {

        Thread t1 = new Thread();
        t1.start();
        t1.start(); // Exception in thread "main" java.lang.IllegalThreadStateException
    }


}
