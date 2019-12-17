package com.lp.juc.transfervalue;

/**
 * @Author: lp
 * @Date： 2019/11/30 10:14
 * @Description：
 * @Version: 1.0
 */
public class Person {

    private Integer id;
    private String personName;

    public Person(){}

    public Person(String personName){
        this.personName = personName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
