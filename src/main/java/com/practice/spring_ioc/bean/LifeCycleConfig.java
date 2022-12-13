package com.practice.spring_ioc.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifeCycleConfig {

//    @Bean
//    public LifeCycleInterface lifeCycleInterface() {
//        return new LifeCycleInterface();
//    }

//    @Bean(initMethod = "init", destroyMethod = "close")
//    public LifeCycleMethods lifeCycleMethods() {
//        return new LifeCycleMethods();
//    }

    @Bean
    public LifeCycleAnnotations lifeCycleAnnotations() {
        return new LifeCycleAnnotations();
    }
}
