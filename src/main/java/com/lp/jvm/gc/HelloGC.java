package com.lp.jvm.gc;

/**
 * @Author: lp
 * @Date： 2019/12/8 21:55
 */
public class HelloGC {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("******HelloGC");

        Thread.sleep(Integer.MAX_VALUE);
    }
}
