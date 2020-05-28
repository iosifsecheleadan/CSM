package com.example.conferencemanagementsystem.service;

import com.example.conferencemanagementsystem.model.Author;
import com.example.conferencemanagementsystem.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }
}
