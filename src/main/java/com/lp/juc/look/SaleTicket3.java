package com.lp.juc.look;

/**
 * @Author: lp
 * @Date： 2019/11/17 13:46
 * @Description： 匿名内部类
 * @Version: 1.0
 */
public class SaleTicket3 {

    public static void main(String[] args) {

        Ticket3 ticket3 = new Ticket3();

        new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i = 0; i < 40; i++) {
                    ticket3.saleTicket();
                }
            }
        },"AA").start();

        new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i = 0; i < 40; i++) {
                    ticket3.saleTicket();
                }
            }
        },"BB").start();

        new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i = 0; i < 40; i++) {
                    ticket3.saleTicket();
                }
            }
        },"CC").start();
    }
}

class Ticket3{

    private int number = 30;

    public synchronized void saleTicket(){
        if (number > 0){
            System.out.println(Thread.currentThread().getName()+"\t卖出了第"+(number--)+"张票,还剩下"+(number)+"张票");
        }
    }
}
