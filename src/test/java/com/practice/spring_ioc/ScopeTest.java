package com.practice.spring_ioc;

import com.practice.spring_ioc.bean.PrototypeBean;
import com.practice.spring_ioc.bean.SingleBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootTest
public class ScopeTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void bean_scope() throws Exception {
        ApplicationRunner applicationRunner = args -> {
            log.info("SingleBean : {}", context.getBean(SingleBean.class));
            log.info("SingleBean : {}", context.getBean(SingleBean.class));
            log.info("SingleBean : {}", context.getBean(SingleBean.class));

            log.info("PrototypeBean : {}", context.getBean(PrototypeBean.class));
            log.info("PrototypeBean : {}", context.getBean(PrototypeBean.class));
            log.info("PrototypeBean : {}", context.getBean(PrototypeBean.class));
        };

        applicationRunner.run(null);
    }

    @Test
    public void bean_scope_2() throws Exception {
        ApplicationRunner applicationRunner = args -> {
            log.info("SingleBean.PrototypeBean : {}", context.getBean(SingleBean.class).getPrototypeBean());
            log.info("SingleBean.PrototypeBean : {}", context.getBean(SingleBean.class).getPrototypeBean());
            log.info("SingleBean.PrototypeBean : {}", context.getBean(SingleBean.class).getPrototypeBean());
        };

        applicationRunner.run(null);
    }
}