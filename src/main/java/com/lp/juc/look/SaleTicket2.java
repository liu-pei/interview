package com.lp.juc.look;

/**
 * @Author: lp
 * @Date： 2019/11/17 11:58
 * @Description： 继承Thread类
 * @Version: 1.0
 */
public class SaleTicket2 {

    public static void main(String[] args) {
        new Ticket2().start();
        new Ticket2().start();
        new Ticket2().start();
    }
}

class Ticket2 extends Thread{

    private static int number = 30;

    @Override
    public void run() {
        for (int i = 1; i <=40 ; i++) {
            saleTicket();
        }
    }

    public static synchronized void saleTicket(){
        if (number > 0){
            System.out.println(Thread.currentThread().getName()+"\t卖出了第"+(number--)+"张票,还剩下"+(number)+"张票");
        }
    }
}
