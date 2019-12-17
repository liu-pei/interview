package com.lp.juc.notsafe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author: lp
 * @Date： 2019/11/25 22:53
 *
 * ArrayList:
 * 1.故障现象
 * java.util.ConcurrentModificationException
 *
 * 2.导致原因
 *
 * 3.解决方案
 *      3.1 Vector();
 *      3.2 Collections.synchronizedList(new ArrayList());
 *          Collections.synchronizedSet();
 *          Collections.synchronizedMap();
 *      3.3 CopyOnWriterArrayList();
 *          CopyOnWriterArraySet();
 *          ConcurrentHashMap();
 *
 * 4. 优化建议(同样的错误,不出现第二次)
 */
public class NotSafeDemo {

    public static void main(String[] args) {

        //ListNotSafe();
        //SetNotSafe();
        MapNotSafe();
    }

    private static void MapNotSafe() {
        Map<String,String> map = new ConcurrentHashMap<>(30);
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }

    public static void ListNotSafe(){

        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }

    /**
     * hashSet底层是hashMap
     *  public HashSet() {
     *         map = new HashMap<>();
     *  }
     *  add()方法底层是haspMap的put()方法,add()是hashMap的键,值为Object类型的PRESENT常量
     */
    public static void SetNotSafe(){

        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
