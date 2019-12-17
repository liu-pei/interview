package com.lp.thread;

/**
 * @Author: lp
 * @Date： 2019/12/3 15:51
 *
 * 单例模式(高并发) DCL + volatile
 */
public class SingletonDemo {

    /**
     * 禁止指令重排
     */
    private static volatile SingletonDemo instance = null;

    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"\t我是构造方法SingletonDemo()");
    }

    /**
     * DCL模式(Double Check Lock 双端检锁机制)
     * @return
     */
    public static SingletonDemo getInstance(){
        if (instance == null){
            synchronized (SingletonDemo.class){
                if (instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {

        // 单线程(main线程的操作动作......)
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.instance);
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.instance);
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.instance);
//
//        System.out.println();
//        System.out.println();
//        System.out.println();

        // 并发多线程后,情况发生了很大的变化......
        for(int i = 1;i <= 10; i++){
            new Thread(() -> {
                SingletonDemo.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
