package com.practice.spring_ioc;

import com.practice.spring_ioc.bean.Pojo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ContainerTest {

    @Test
    public void beanFactory_lazy_loading() {
        Resource res = new ClassPathResource("bean_factory.xml");
        BeanFactory factory = new XmlBeanFactory(res);

        assertFalse(Pojo.isBeanInstantiated());

        Pojo pojo = (Pojo) factory.getBean("pojo");

        assertTrue(Pojo.isBeanInstantiated());
    }

    @Test
    public void applicationContext_pre_loading(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean_factory.xml");

        assertTrue(Pojo.isBeanInstantiated());
    }
}

