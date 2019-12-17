package com.lp.jvm;

/**
 * @Author: lp
 * @Date： 2019/12/2 17:28
 * @Description：
 * @Version: 1.0
 */
public class Heap {

    public static void main(String[] args) {


       /* // 返回java虚拟机试图使用的最大内存量
        long maxMemory = Runtime.getRuntime().maxMemory();

        // 返回java虚拟机中的内存总量
        long totalMemory = Runtime.getRuntime().totalMemory();

        System.out.println("-Xmx:MAX_MEMORY = " + maxMemory + "(字节)、" + (maxMemory / (double)1024 / 1024) + "MB");
        System.out.println("-Xms:TOTAL_MEMORY = " + totalMemory + "(字节)、" + (totalMemory / (double)1024 / 1024) + "MB");*/


       // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
      /* String str = "love";
       while (true){
           str += str + new Random().nextInt(8888888) + new Random().nextInt(99999999);
       }*/

        // System.gc();
    }
}
