package com.practice.spring_ioc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoinService {

    @Autowired
    public CoinRepository coinRepository;

    public void setCoinRepository(CoinRepository coinRepository) {
        this.coinRepository = coinRepository;
    }
}
