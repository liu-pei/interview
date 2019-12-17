package com.lp.juc.look;

/**
 * @Author: lp
 * @Date： 2019/11/17 11:18
 * @Description： 实现Runnable接口实现线程同步
 * @Version: 1.0
 */
public class SaleTicket1 {

    public static void main(String[] args) {

        Ticket1 ticket = new Ticket1();

        new Thread(ticket,"AA").start();
        new Thread(ticket,"BB").start();
        new Thread(ticket,"CC").start();
    }

}

/**
 * 资源类
 */
class Ticket1 implements Runnable{

    private int number = 30;

    @Override
    public void run() {
        for (int i = 1; i <=40 ; i++) {
            saleTicket();
        }
    }

    public synchronized void saleTicket(){
        if (number > 0){
            System.out.println(Thread.currentThread().getName()+"\t卖出了第"+(number--)+"张票,还剩下"+(number)+"张票");
        }
    }

}
