package com.practice.spring_ioc;

import com.practice.spring_ioc.bean.*;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
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

    @Test
    public void singleton_container() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BookService bookService1 = context.getBean("bookService", BookService.class);
        BookService bookService2 = context.getBean("bookService", BookService.class);

        assertThat(bookService1).isEqualTo(bookService2);
    }

    @Test
    public void cglib_proxy() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig appConfig = context.getBean("appConfig", AppConfig.class);
        OrderService orderService = context.getBean("orderService", OrderService.class);
        OrderServiceV2 orderServiceV2 = context.getBean("orderServiceV2", OrderServiceV2.class);

        log.info("appConfig : {}", appConfig.getClass());
        log.info("orderService.bookRepository : {}", orderService.getBookRepository());
        log.info("orderServiceV2.bookRepository : {}", orderServiceV2.getBookRepository());
    }
}

