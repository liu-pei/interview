package com.lp.juc.look;

/**
 * @Author: lp
 * @Date： 2019/11/17 14:20
 * @Description： lambda表达式
 * @Version: 1.0
 */
public class LambdaExpressDome {

    public static void main(String[] args) {
        /*Foo foo = new Foo() {
            @Override
            public void sayHello() {
                System.out.println("***hello***");
            }
        };
        foo.sayHello();*/

        Foo foo = () -> {System.out.println("***hello lambdaExpress***");};
        foo.sayHello();
        System.out.println(foo.div(5, 2));
        System.out.println(foo.min(5, 2));
        System.out.println(Foo.mul(5, 2));
        System.out.println(Foo.add(5, 2));

        Foo1 foo1 = (x,y) -> {
            System.out.println("*** (x,y)->  add() ***");
            return x+y;
        };
        System.out.println(foo1.add(2, 3));

    }

}

/**
 * 函数式接口 @FunctionalInterface可以省略
 */
@FunctionalInterface
interface Foo{

    void sayHello();

    default int div(int x, int y){
        System.out.println("****default div()*****");
        return x/y;
    }

    default int min(int x, int y){
        System.out.println("****default min()*****");
        return x-y;
    }


    static int mul(int x, int y){
        System.out.println("***static mul()***");
        return x*y;
    }

    static int add(int x, int y){
        System.out.println("***static add()***");
        return x+y;
    }

}

interface Foo1{

    int add(int x, int y);
}
