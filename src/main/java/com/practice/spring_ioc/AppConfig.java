package com.practice.spring_ioc;

import com.practice.spring_ioc.bean.BookRepository;
import com.practice.spring_ioc.bean.OrderService;
import com.practice.spring_ioc.bean.OrderServiceV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
//@ComponentScan(basePackageClasses = SpringIocApplication.class)
public class AppConfig {

//    @Bean
//    public BookService bookService() {
//        BookService bookService = new BookService();
//        bookService.setBookRepository(bookRepository());
//        return bookService;
//    }
//
//    @Bean
//    public BookRepository bookRepository() {
//        return new BookRepository();
//    }

    @Bean
    public OrderService orderService() {
        return new OrderService(bookRepository());
    }

    @Bean
    public OrderServiceV2 orderServiceV2() {
        return new OrderServiceV2(bookRepository());
    }

    @Bean
    public BookRepository bookRepository() {
        return new BookRepository();
    }
}
