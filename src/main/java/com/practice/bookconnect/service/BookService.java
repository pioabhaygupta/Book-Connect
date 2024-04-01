package com.practice.bookconnect.service;

import com.practice.bookconnect.exception.AuthorNotFoundException;
import com.practice.bookconnect.exception.BookNotFoundException;
import com.practice.bookconnect.model.Author;
import com.practice.bookconnect.model.Book;
import com.practice.bookconnect.repository.AuthorRepository;
import com.practice.bookconnect.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    public Book addBook(Long id, Book book) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        //we will check if author exists or not
        if (!authorOptional.isPresent()) {
            throw new AuthorNotFoundException("Author not found");
        }
        Author author = authorOptional.get();
        book.setAuthor(author);
        return bookRepository.save(book);
    }
    public Book getBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (!optionalBook.isPresent()) {
            throw new BookNotFoundException("Book Not Found");
        }
        return optionalBook.get();
    }
}
