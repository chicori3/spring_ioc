package com.practice.spring_ioc;

import com.practice.spring_ioc.bean.BookService;
import com.practice.spring_ioc.bean.CoinService;
import com.practice.spring_ioc.bean.MemberService;
import com.practice.spring_ioc.bean.Pojo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import static org.assertj.core.api.Assertions.assertThat;
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
    public void applicationContext_pre_loading() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean_factory.xml");

        assertTrue(Pojo.isBeanInstantiated());
    }

    @Test
    public void dependency_injection_bean_tag() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        MemberService memberService = (MemberService) context.getBean("memberService");

        assertThat(beanDefinitionNames.length).isEqualTo(2);
        assertThat(memberService.memberRepository).isNotNull();
    }

    @Test
    public void dependency_injection_component_scan() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application_scan.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        CoinService coinService = (CoinService) context.getBean("coinService");

        assertThat(beanDefinitionNames.length).isGreaterThanOrEqualTo(2);
        assertThat(coinService.coinRepository).isNotNull();
    }

    @Test
    public void annotation_config() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        BookService bookService = (BookService) context.getBean("bookService");

        assertThat(beanDefinitionNames.length).isGreaterThanOrEqualTo(2);
        assertThat(bookService.bookRepository).isNotNull();
    }
}

