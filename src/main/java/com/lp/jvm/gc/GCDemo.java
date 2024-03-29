package com.lp.jvm.gc;

import java.util.Random;

/**
 * @Author: lp
 * @Date： 2019/12/11 10:28
 *
 * 垃圾收集器GC
 *
 * 1:
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC         (DefNew+Tenured)
 *
 * 2:
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC         (ParNew+Tenured)
 *
 *  备注情况: Java HotSpot(TM) 64-Bit Server VM warning:
 *  Using the ParNew young collector with the Serial old collector is deprecated
 *  and will likely be removed in a future release
 *
 * 3:
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC        (PSYoungGen+ParOldGen)
 *
 * 4:
 *  4.1:
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelOldGC     (PSYoungGen+ParOldGen)
 *  4.2:  (不加就是默认UseParallelGC)
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags                           (PSYoungGen+ParOldGen)
 *
 * 5:
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC   (par new generation+concurrent mark-sweep generation)
 *
 * 6:
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseG1GC              后面单独看
 *
 * 7:(理论知道即可,实际中java8已经被优化掉了,没有了。)
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialOldGC
 */
public class GCDemo {

    public static void main(String[] args) {

        System.out.println("************GCDemo hello");

        String str = "love";

        while (true){
            str += str + new Random().nextInt(888888888) + new Random().nextInt(999999999);
            str.intern();
        }
    }
}
