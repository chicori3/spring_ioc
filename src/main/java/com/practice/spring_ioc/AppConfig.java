package com.practice.spring_ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = SpringIocApplication.class)
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
}
