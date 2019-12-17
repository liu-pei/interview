package com.lp.jvm;


class Code{

    public Code() {
        System.out.println("Code的构造方法111");
    }

    {
        System.out.println("Code的构造快222");
    }

    static{
        System.out.println("Code的静态代码块333");
    }
}

/**
 * @Author: lp
 * @Date： 2019/12/3 10:48
 */
public class CodeBlock { // 主类  CodeBlock.class ---> main

    {
        System.out.println("CodeBlock的构造快444");
    }

    static{
        System.out.println("CodeBlock的静态代码块555");
    }

    public CodeBlock() {
        System.out.println("CodeBlock的构造方法666");
    }

    public static void main(String[] args) {

        System.out.println("=====我是美丽分界线=====CodeBlock的main方法777");

        new Code();
        System.out.println("-------------------------");

        new Code();
        System.out.println("-------------------------");

        new CodeBlock();
    }
}
