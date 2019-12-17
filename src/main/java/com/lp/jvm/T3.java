package com.lp.jvm;


class MyNumber{

    volatile int number = 10;

    public void addTO1024(){
        this.number = 1024;
    }
}

/**
 * @Author: lp
 * @Date： 2019/12/3 10:32
 *
 * JMM = 可见性(通知机制)
 */
public class T3 {

    public static void main(String[] args) {

        MyNumber myNumber = new MyNumber();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+" ******come in here");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 将10修改为1024
            myNumber.addTO1024();
            System.out.println(Thread.currentThread().getName()+"\t update number, number value: "+myNumber.number);
        },"A").start();

        while (myNumber.number == 10){
            // 需要有一种通知机制告诉main线程,number已经修改为1024,跳出while
        }

        System.out.println(Thread.currentThread().getName()+"\t mission is over");
    }
}
