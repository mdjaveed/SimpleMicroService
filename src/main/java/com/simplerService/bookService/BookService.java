package com.simplerService.bookService;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Cacheable("books")
    public String getBookNameByIsbn(String isbn) throws InterruptedException {
        return findBookInSlowSource(isbn);
    }

    private String findBookInSlowSource(String isbn) throws InterruptedException {
            Thread.sleep(3000);
        return "Sample Book Name";
    }
}