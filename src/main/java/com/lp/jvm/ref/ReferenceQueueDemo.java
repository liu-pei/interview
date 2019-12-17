package com.lp.jvm.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @Author: lp
 * @Date： 2019/12/9 16:23
 */
public class ReferenceQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(o1,referenceQueue);
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("=========================");

        o1 = null;
        System.gc();

        Thread.sleep(500);
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
    }
}