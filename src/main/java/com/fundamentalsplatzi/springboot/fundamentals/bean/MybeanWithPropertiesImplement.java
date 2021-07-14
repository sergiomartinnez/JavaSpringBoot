package com.fundamentalsplatzi.springboot.fundamentals.bean;

public class MybeanWithPropertiesImplement implements MyBeanWithProperties{

    private String name;
    private String lastname;

    public MybeanWithPropertiesImplement(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    @Override
    public String function() {
        return name + "-" + lastname;
    }
}
