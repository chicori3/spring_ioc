package com.practice.spring_ioc;

import com.practice.spring_ioc.bean.LifeCycleConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleTest {

//    @Test
//    public void lifeCycle_interfaces() {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
//        context.getBean("lifeCycleInterface");
//        context.close();
//    }

//    @Test
//    public void lifeCycle_methods() {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
//        context.getBean("lifeCycleMethods");
//        context.close();
//    }

    @Test
    public void lifeCycle_annotations() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        context.getBean("lifeCycleAnnotations");
        context.close();
    }
}
