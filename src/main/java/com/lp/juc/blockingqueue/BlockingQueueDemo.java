package com.lp.juc.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: lp
 * @Date： 2019/11/29 22:10
 *
 * 阻塞队列
 *
 * 当队列是空的，从队列中获取元素的操作将会被阻塞
 * 当队列是满的，从队列中添加元素的操作将会被阻塞
 * 试图从空的队列中获取元素的线程将会被阻塞，直到其他线程往空的队列插入新的元素
 * 试图向已满的队列中添加新元素的线程将会被阻塞，直到其他线程从队列中移除一个或多个元素或者完全清空，使队列变得空闲起来并后续新增
 *
 * 1    两个数据结构: 栈/队列
 *   1.1 栈      后进先出
 *   1.2 队列     先进后出
 *   1.3 总结
 *
 * 2    阻塞对列
 *   2.1 阻塞  必须要阻塞/不得不阻塞
 *
 * 3    how
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        // List list = new ArrayList();
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        /*System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        // System.out.println(blockingQueue.add("x"));

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

        // System.out.println(blockingQueue.remove());*/

        /**
         * 当阻塞队列满时，再往队列里add插入元素会抛IllegalStateException:Queue full
         * 当阻塞队列空时，再往队列里remove移除元素会抛NoSuchElementException
         */

        /*System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.element());  // 对首元素*/

       /* System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        // System.out.println(blockingQueue.offer("x"));  // false

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        // System.out.println(blockingQueue.poll());  // null*/

        /**
         * 插入方法，成功ture失败false
         * 移除方法，成功返回出队列的元素，队列里没有就返回null
         */

        /*blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");
        // blockingQueue.put("a");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        // System.out.println(blockingQueue.take());*/

        /**
         * 当阻塞队列满时，生产者线程继续往队列里put元素，队列会一直阻塞生产者线程直到put数据or响应中断退出
         * 当阻塞队列空时，消费者线程试图从队列里take元素，队列会一直阻塞消费者线程直到队列可用
         */

        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));

        /**
         * 当阻塞队列满时，队列会阻塞生产者线程一定时间，超过限时后生产者线程会退出
         */

    }

}
