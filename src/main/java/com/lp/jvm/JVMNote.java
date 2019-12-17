package com.lp.jvm;

/**
 * @Author: lp
 * @Date： 2019/12/2 10:51
 * @Description： 栈执行顺序
 * @Version: 1.0
 */
public class JVMNote {

    /**
     * 输入参数输出参数以及方法内的变量
     * @param x
     * @param y
     * @return
     */
    public int add(int x ,int y){
        int result = -1;
        result = x + y;
        return result;
    }

    public static void m1(){
        System.out.println("222");
        System.out.println("******m1");
        System.out.println("333");

    }

    public static void main(String[] args) {
        System.out.println("111");
        m1();
        System.out.println("444");

    }

}
