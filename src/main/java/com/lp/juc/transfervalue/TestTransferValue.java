package com.lp.juc.transfervalue;

/**
 * @Author: lp
 * @Date： 2019/11/30 10:16
 *
 * 基本类型不变,自定义引用类型改变
 * String 字符串常量池,没有就重建,有就复用
 */
public class TestTransferValue {

    public void changeValue1(int age){
        age = 30;
    }
    public void changeValue2(Person person){
        person.setPersonName("xxx");
    }
    public void changeValue3(String str){
        str = "xxx";
    }

    public static void main(String[] args) {
        TestTransferValue test = new TestTransferValue();
        int age = 20;
        test.changeValue1(age);
        System.out.println("age---"+age); // 20

        Person person = new Person("abc");
        test.changeValue2(person);
        System.out.println("personName---"+person.getPersonName()); // xxx

        String str = "abc";
        test.changeValue3(str);
        System.out.println("String---"+str); // abc
    }
}
