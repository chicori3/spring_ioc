package com.practice.spring_ioc.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class PrototypeBean {

//    @Autowired
//    SingleBean singleBean;
}
