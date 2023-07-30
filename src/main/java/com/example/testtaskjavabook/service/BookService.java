package com.example.testtaskjavabook.service;

import com.example.testtaskjavabook.repository.BookRepository;
import com.example.testtaskjavabook.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class BookService {
    private final WebClient webClient;
    private final BookRepository repository;

    public BookService(WebClient.Builder webClientBuilder, BookRepository repository) {
        this.webClient = webClientBuilder
                .baseUrl("https://ru.wikipedia.org/w/api.php")
                .build();
        this.repository = repository;
    }

    public Mono<Object> someRestCall(String name) {
        return this.webClient
                .get()
                .uri("?action=query&list=search&srsearch={name}&format=json", name).accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Object.class);
    }

    public List<Book> listBook() {
       // return repository.gtBookandAuthor();
        return repository.getBooks();
    }
}
