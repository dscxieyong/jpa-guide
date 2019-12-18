package com.orange.jpa.initial;

import com.orange.jpa.initial.domain.Book;
import com.orange.jpa.initial.domain.BookPublisher;
import com.orange.jpa.initial.domain.Publisher;
import com.orange.jpa.initial.repository.BookRepository;
import com.orange.jpa.initial.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        Book bookA = new Book("Book A");

        Publisher publisherA = new Publisher("Publisher A");

        BookPublisher bookPublisher = new BookPublisher();
        bookPublisher.setBook(bookA);
        bookPublisher.setPublisher(publisherA);
        bookPublisher.setPublishedDate(new Date());
        bookA.getBookPublishers().add(bookPublisher);

        publisherRepository.save(publisherA);
        bookRepository.save(bookA);

        // test
        System.out.println(bookA.getBookPublishers().size());

        // update
        bookA.getBookPublishers().remove(bookPublisher);
        bookRepository.save(bookA);

        // test
        System.out.println(bookA.getBookPublishers().size());
    }

}
