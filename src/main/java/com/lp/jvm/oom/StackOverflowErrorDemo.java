package com.lp.jvm.oom;

/**
 * @Author: lp
 * @Date： 2019/12/10 9:43
 */
public class StackOverflowErrorDemo {

    public static void main(String[] args) {

        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError(); // Exception in thread "main" java.lang.StackOverflowError
    }
}
