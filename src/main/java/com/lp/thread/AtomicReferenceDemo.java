package com.lp.thread;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

@Getter
@ToString
@AllArgsConstructor
class User{

    private String userName;

    private int age;
}

/**
 * @Author: lp
 * @Date： 2019/12/4 11:30
 *
 * 原子引用
 *
 * 解决ABA问题 ??? 理解原子引用 + 新增一种机制:修改版本号(类似时间戳)
 */
public class AtomicReferenceDemo {

    public static void main(String[] args) {

        User zhang3 = new User("zhang3",22);
        User li4 = new User("li4",25);

        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(zhang3);

        System.out.println(atomicReference.compareAndSet(zhang3, li4) + "\t" +atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(zhang3, li4) + "\t" +atomicReference.get().toString());
    }
}
