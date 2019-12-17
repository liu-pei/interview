package com.lp.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 资源类
 */
class MyCache{
    private volatile Map<String,Object> map = new HashMap<>(16);
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object value){

        readWriteLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在写入: "+key);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成 ");
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key){
       readWriteLock.readLock().lock();
       try{
           System.out.println(Thread.currentThread().getName()+"\t 正在读取... ");
           try {
               TimeUnit.MILLISECONDS.sleep(300);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           Object result = map.get(key);
           System.out.println(Thread.currentThread().getName()+"\t 读取完成: "+result);
       }catch (Exception e){
           e.printStackTrace();
       }finally{
           readWriteLock.readLock().unlock();
       }

    }

    public void clearMap(){
        map.clear();
    }
}

/**
 * @Author: lp
 * @Date： 2019/12/5 21:27
 *
 * 多个线程同时读一个资源类没有任何问题,所提为了满足并发量,读取共享资源应该可以同时进行。
 * 但是
 * 如果一个线程想去写共享资源,就不应该再有其他线程可以对该资源进行读或写
 * 小总结:
 *      读-读能共存
 *      读-写不能共存
 *      写-写不能共存
 *
 *      写操作: 原子+独占,整个过程必须是完整的统一体,中间不许被分割,被打断
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {

        MyCache myCache = new MyCache();

        for(int i = 1;i <= 5; i++){
            final int temp = i;
            new Thread(() -> {
                myCache.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }

        for(int i = 1;i <= 5; i++){
            final int temp = i;
            new Thread(() -> {
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }
    }
}
