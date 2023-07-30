package com.example.testtaskjavabook.repository;

import com.example.testtaskjavabook.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "select b.id, book_name, a.id as id_authors, author_full_name from book b inner join book_author ba on b.id = ba.id_book inner join author a on a.id = ba.id_author;", nativeQuery = true)
    List<Book> getBooks();
    //select b from book b inner join book_author ba on b.id = ba.id_book inner join author a on a.id = ba.id_author"


}
