package com.practice.spring_ioc.bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LifeCycleMethods {

    public void init() {
        log.info("빈 생성 콜백 메서드 호출");
    }

    public void close() {
        log.info("빈 소멸 콜백 메서드 호출");
    }
}
