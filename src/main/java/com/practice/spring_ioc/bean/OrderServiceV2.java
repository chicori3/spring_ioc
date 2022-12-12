package com.practice.spring_ioc.bean;

public class OrderServiceV2 {

    BookRepository bookRepository;

    public OrderServiceV2(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }
}
