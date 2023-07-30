package com.example.testtaskjavabook.controller;

import com.example.testtaskjavabook.model.Book;
import com.example.testtaskjavabook.service.BookService;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/{id}/wiki") //поиск информации о книге в Википедии
    public Mono<Object> getWiki(@PathVariable("id") @NotBlank String id) {
        return bookService.someRestCall(id);

    }

    @GetMapping("/book") //получение списка книг и их авторов
    public List<Book> bookList() {
        return bookService.listBook();

    }

    @GetMapping("/book/{id}") //получение информации по определенной книге
    public Book bookInfo() {
        return null;
    }

    @PostMapping("/book") //добавление информации о книге в БД
    public void addBook() {

    }

    @GetMapping("/authors") //получение списка авторов
    public void listAuthors() {

    }
}
