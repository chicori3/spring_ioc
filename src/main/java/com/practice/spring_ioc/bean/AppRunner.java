package com.practice.spring_ioc.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext context;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("SingleBean : {}", context.getBean(SingleBean.class));
        log.info("SingleBean : {}", context.getBean(SingleBean.class));
        log.info("SingleBean : {}", context.getBean(SingleBean.class));

        log.info("PrototypeBean : {}", context.getBean(PrototypeBean.class));
        log.info("PrototypeBean : {}", context.getBean(PrototypeBean.class));
        log.info("PrototypeBean : {}", context.getBean(PrototypeBean.class));
    }
}
