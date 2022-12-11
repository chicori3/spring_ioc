package com.practice.spring_ioc.bean;

public class Pojo {
    public static boolean beanInstantiated = false;

    public void postConstruct(){
        setIsBeanInstantiated(true);
    }

    public static boolean isBeanInstantiated() {
        return beanInstantiated;
    }

    public static void setIsBeanInstantiated(boolean isBeanInstantiated) {
        Pojo.beanInstantiated = isBeanInstantiated;
    }
}
