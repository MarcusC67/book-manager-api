package com.techreturners.bookmanager.repository;

import com.techreturners.bookmanager.model.Book;
import com.techreturners.bookmanager.model.Genre;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


// testing for update, delete, add new book etc
// if something built in then don't need to test it!!! so this test not needed.
// NO NEED TEST REPOSITORY because already tested as a package!
@DataJpaTest
public class BookManagerRepositoryTests {

    @Autowired
    private BookManagerRepository bookManagerRepository;

    @Test
    public void testFindAllBooksReturnsBooks() {

        Book book = new Book(1L, "Book One", "This is the description for Book One", "Person One", Genre.Education);
        bookManagerRepository.save(book);

        Iterable<Book> books = bookManagerRepository.findAll();
        assertThat(books).hasSize(1);

    }

    @Test
    public void testCreatesAndFindBookByIdReturnsBook() {

        Book book = new Book(2L, "Book Two", "This is the description for Book Two", "Person Two", Genre.Fantasy);
        bookManagerRepository.save(book);

        var bookById = bookManagerRepository.findById(book.getId());
        assertThat(bookById).isNotNull();

    }

}
