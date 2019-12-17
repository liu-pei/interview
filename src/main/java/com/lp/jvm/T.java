package com.lp.jvm;

/**
 * @Author: lp
 * @Date： 2019/12/2 9:32
 * @Description：
 * @Version: 1.0
 */
public class T {

    public static void main(String[] args) {

        Thread t = new Thread();
        t.start();
        // Exception in thread "main" java.lang.IllegalThreadStateException
        t.start();
    }
}
