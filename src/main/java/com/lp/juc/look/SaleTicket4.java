package com.lp.juc.look;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: lp
 * @Date： 2019/11/17 13:53
 * @Description： JUC实现线程同步
 * @Version: 1.0
 */
public class SaleTicket4 {

    public static void main(String[] args) {

        // 线程   操作(对外暴露的调用方法)  资源类

        Ticket4 ticket4 = new Ticket4();

        /*new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i = 0; i < 40; i++) {
                    ticket4.saleTicket();
                }
            }
        },"AA").start();

        new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i = 0; i < 40; i++) {
                    ticket4.saleTicket();
                }
            }
        },"BB").start();

        new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i = 0; i < 40; i++) {
                    ticket4.saleTicket();
                }
            }
        },"CC").start();*/

        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket4.saleTicket();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket4.saleTicket();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket4.saleTicket();
            }
        },"C").start();
    }
}

/**
 * 资源类
 */
class Ticket4{

    private Lock lock = new ReentrantLock();

    private int number = 30;

    public void saleTicket(){
        
        lock.lock();
        try{
            if (number > 0){
                System.out.println(Thread.currentThread().getName()+"\t卖出了第"+(number--)+"张票,还剩下"+(number)+"张票");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
