package com.practice.bookconnect.service;

import com.practice.bookconnect.exception.AuthorNotFoundException;
import com.practice.bookconnect.model.Author;
import com.practice.bookconnect.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author getAuthor(Long id) {
        Optional<Author> author= authorRepository.findById(id);
        if(author.isPresent()){
            return author.get();
        }
        throw new AuthorNotFoundException("Author details not found");
    }

    public String removeAuthor(Long id) {
        Optional<Author> author=authorRepository.findById(id);
        if(author.isPresent()){
            authorRepository.deleteById(id);
            return "Author details deleted successfully";
        }
        throw new AuthorNotFoundException("Author details not found");
    }

    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }
}

