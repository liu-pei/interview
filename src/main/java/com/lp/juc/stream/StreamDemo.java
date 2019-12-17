package com.lp.juc.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
class User{
    private Integer id;
    private String userName;
    private int age;

}
/**
 * @Author: lp
 * @Date： 2019/11/30 20:00
 *
 * 题目:请按照给出数据,找出同时满足以下条件的用户
 *      偶数id且年龄大于24且用户名转为大写且用户名字符倒叙排列
 *      只输出一个用户名字
 */
public class StreamDemo {

    public static void main(String[] args) {

        User u1 = new User(11,"a",23);
        User u2 = new User(12,"b",24);
        User u3 = new User(13,"c",22);
        User u4 = new User(14,"d",28);
        User u5 = new User(16,"e",26);

        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);

        list.stream().filter(user -> {
            return user.getId() % 2 == 0;
        }).filter(user -> {
             return user.getAge() > 24;
        }).map(m -> {
            return m.getUserName().toUpperCase();
        }).sorted((o1, o2) -> {
            return o2.compareTo(o1);
        }).limit(1) .forEach(System.out::println);


        /*List<Integer> list2 = Arrays.asList(1,2,3);

        list2 = list2.stream().map(x -> {return x * 2;}).collect(Collectors.toList());

        for (Integer element : list2) {
            System.out.println(element);
        }*/


        // =========================================================

       /* Function<String,Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        }
        Function<String,Integer> function = s -> { return s.length(); };
        System.out.println(function.apply("abc"));*/

       /* Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };
        Predicate<String> predicate = s -> { return s.isEmpty(); };
        System.out.println(predicate.test("liupei"));*/

        /*Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {

            }
        };
        Consumer<String> consumer = s -> { System.out.println(s); };
        consumer.accept("liupei");*/

        /*Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return null;
            }
        };
        Supplier<String> supplier = () -> {return "java8";};
        System.out.println(supplier.get());*/
    }
}

interface MyInterface{

    public int myInt(int x);
    public String myString(String str);
    public boolean isOk(String str);
}
