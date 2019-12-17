package com.lp.thread;

import java.util.concurrent.atomic.AtomicInteger;

class MyData{

    volatile int number = 0;

    public void addTo60(){
        this.number = 60;
    }


    public void addPlusPlus(){
        // 请注意,此时number前面是加了volatile关键字修饰的,volatile不保证原子性
        number ++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }
}
/**
 * @Author: lp
 * @Date： 2019/12/3 14:00
 *
 * 1 验证volatile的可见性
 *    1.1 假如 int number = 0; number变量之前没有添加volatile关键字修饰,没有可见性
 *    1.2 添加了volatile可以解决可见性问题

 * 2 验证volatile不保证原子性
 *    2.1 原子性指的是什么意思?
 *        不可分割,完整性,也即某个线程正在做某个具体业务时,中间不可以被加塞或者被分割。需要整体完整
 *        要么同时成功,要么同时失败
 *    2.2 volatile不保证原子性的案例演示
 *    2.3 why?
 *    2.4 如何解决原子性?
 *      1) 加synchronized
 *      2) 使用juc下AtomicInteger
 *
 */
public class VolatileDemo {

    public static void main(String[] args) {

        // visibilityByVolatile();
        atomicityNotByVolatile();
    }

    /**
     * volatile不保证原子性
     */
    private static void atomicityNotByVolatile() {
        MyData myData = new MyData();

        for(int i = 1;i <= 20; i++){
            new Thread(() -> {
                for (int j = 1; j <= 1000 ; j++) {
                    myData.addPlusPlus();
                    myData.addMyAtomic();
                }
            },String.valueOf(i)).start();
        }

        // 需要等待上面20个线程都全部计算完成后,再用main线程取得最终的结果值看是多少?
        while (Thread.activeCount() > 2){
            // 线程礼让
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+"\t int type, finally number value: "+myData.number);
        System.out.println(Thread.currentThread().getName()+"\t AtomicInteger type, finally number value: "+myData.atomicInteger);
    }

    /**
     * volatile可以保证可见性,及时通知其他线程,主物理内存的值已经被修改
     */
    private static void visibilityByVolatile() {
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+" ******come in here");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 将10修改为1024
            myData.addTo60();
            System.out.println(Thread.currentThread().getName()+"\t update number, number value: "+myData.number);
        },"A").start();

        while (myData.number == 0){
            // 需要有一种通知机制告诉main线程,number已经修改为1024,跳出while
        }

        System.out.println(Thread.currentThread().getName()+"\t mission is over");
    }

}
