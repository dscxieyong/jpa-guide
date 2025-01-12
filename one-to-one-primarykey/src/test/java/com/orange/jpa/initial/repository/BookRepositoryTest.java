package com.orange.jpa.initial.repository;

import com.orange.jpa.initial.domain.Book;
import com.orange.jpa.initial.domain.BookDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void saveTestPrimaryKey() throws Exception {
        List<Book> books = new ArrayList<>();
        books.add(new Book("书本一", new BookDetail(1)));
        books.add(new Book("Book two", new BookDetail(2)));
        books.add(new Book("Book three", new BookDetail(3)));
        books.add(new Book("Book four"));
        bookRepository.save(books);
    }

    @Test
    public void findBooksTestPrimaryKey() throws Exception{
        List<Book> books = bookRepository.findAll();
        for (Book book: books) {
            log.info(book.toString());
        }
    }


}
