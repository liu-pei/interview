package com.lp.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: lp
 * @Date： 2019/12/3 16:34
 *
 * 1    CAS是什么? ===> CompareAndSwap
 *       它的功能是判断内存某个位置的值是否为预期值,如果是则更新为新的值,这个过程是原子的.
 *       比较并交换
 */
public class CASDemo {

    public static void main(String[] args) {

        // 主物理内存初始值5
        AtomicInteger atomicInteger = new AtomicInteger(5);

        // main do something...

        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current date: " + atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t current date: " + atomicInteger.get());


    }
}
