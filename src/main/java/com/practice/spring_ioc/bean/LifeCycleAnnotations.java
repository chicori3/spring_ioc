package com.practice.spring_ioc.bean;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
public class LifeCycleAnnotations {

    @PostConstruct
    public void init() {
        log.info("빈 생성 콜백 어노테이션");
    }

    @PreDestroy
    public void close() {
        log.info("빈 소멸 콜백 어노테이션");
    }
}
