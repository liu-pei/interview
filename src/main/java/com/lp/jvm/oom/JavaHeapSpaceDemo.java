package com.lp.jvm.oom;

import java.util.Random;

/**
 * @Author: lp
 * @Date： 2019/12/10 9:46
 *
 * JVM参数配置
 * -Xms10m -Xmx10m
 */
public class JavaHeapSpaceDemo {

    public static void main(String[] args) {

//        byte [] bytes = new byte[80*1024*1024];  // 80MB

        String str = "love";

        while (true){
            str += str + new Random().nextInt(888888888) + new Random().nextInt(999999999);
            str.intern();
        }
        // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    }
}
