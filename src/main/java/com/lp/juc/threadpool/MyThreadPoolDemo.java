package com.lp.juc.threadpool;

import java.util.concurrent.*;

/**
 * @Author: lp
 * @Date： 2019/11/30 10:47
 *
 *
 * 线程池的优势：
 * 线程池做的工作只要是控制运行的线程数量，处理过程中将任务放入队列，然后在线程创建后启动这些任务，如果线程数量超过了最大数量，超出数量的线程排队等候，等其他线程执行完毕，再从队列中取出任务来执行。
 *
 * 它的主要特点为：线程复用;控制最大并发数;管理线程。
 * 第一：降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的销耗。
 * 第二：提高响应速度。当任务到达时，任务可以不需要等待线程创建就能立即执行。
 * 第三：提高线程的可管理性。线程是稀缺资源，如果无限制的创建，不仅会销耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一的分配，调优和监控。
 *
 *
 * 拒绝策略
 * 等待队列已经排满了，再也塞不下新任务了
 * 同时，
 * 线程池中的max线程也达到了，无法继续为新任务服务。
 * 这个是时候我们就需要拒绝策略机制合理的处理这个问题。
 * 1. AbortPolicy(默认)：直接抛出RejectedExecutionException异常阻止系统正常运行
 * 2. CallerRunsPolicy：“调用者运行”一种调节机制，该策略既不会抛弃任务，也不
 *    会抛出异常，而是将某些任务回退到调用者，从而降低新任务的流量。
 * 3. DiscardOldestPolicy：抛弃队列中等待最久的任务，然后把当前任务加人队列中
 *    尝试再次提交当前任务。
 * 4. DiscardPolicy：该策略默默地丢弃无法处理的任务，不予任何处理也不抛出异常。
 *    如果允许任务丢失，这是最好的一种策略。
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {

        // 内核数
        System.out.println(Runtime.getRuntime().availableProcessors());
        // cup密集型 maximumPoolSize = 内核数 + 1
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try {
            // 模拟有6个顾客来银行办理业务,目前池子里面有5个工作人员提供服务
            for (int i = 1; i <=10 ; i++) {
                threadPool.execute(() ->{
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

    private static void initPool() {
        /**
         * 一池5个工作线程,类似一个银行有5个受理窗口
         */
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);

        /**
         * 一池1个工作线程,类似一个银行有1个受理窗口
         */
        // ExecutorService threadPool = Executors.newSingleThreadExecutor();

        /**
         * 一池N个工作线程,类似一个银行有N个受理窗口
         */
         ExecutorService threadPool = Executors.newCachedThreadPool();

        try {
            // 模拟有10个顾客来银行办理业务,目前池子里面有5个工作人员提供服务
            for (int i = 1; i <=10 ; i++) {
                threadPool.execute(() ->{
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
                });
                TimeUnit.SECONDS.sleep(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
