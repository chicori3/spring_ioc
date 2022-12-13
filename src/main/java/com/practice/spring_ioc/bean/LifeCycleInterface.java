package com.practice.spring_ioc.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Slf4j
public class LifeCycleInterface implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("빈 생성 콜백");
    }

    @Override
    public void destroy() throws Exception {
        log.info("빈 소멸 콜백");
    }
}
