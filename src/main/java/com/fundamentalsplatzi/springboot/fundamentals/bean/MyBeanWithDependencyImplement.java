package com.fundamentalsplatzi.springboot.fundamentals.bean;


import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("We have entered the method printWithDependency");
        int numero=1;
        LOGGER.debug("the number sended as parameter for the dependency operation is: " + numero);
        System.out.println(myOperation.sum(numero));
        System.out.println("Hello from the implementation of a bean with dependency");
    }
}
