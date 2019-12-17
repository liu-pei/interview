package com.lp.jvm.ref;

/**
 * @Author: lp
 * @Date： 2019/12/9 15:27
 *
 * 强引用
 * 当内存不足,JVM开始垃圾回收,对于强引用对象,就算是出现了OOM也不会对该对象进行回收,死都不收
 *即使该对象以后永远都不会被用到JVM也不会回收
 */
public class StrongReferenceDemo {

    public static void main(String[] args) {

        Object o1 = new Object(); //这样定义默认就是强引用
        Object o2 = o1;  // o2引用赋值
        o1 = null; // 置空
        System.gc();
        System.out.println(o2); //java.lang.Object@1540e19d
    }
}
