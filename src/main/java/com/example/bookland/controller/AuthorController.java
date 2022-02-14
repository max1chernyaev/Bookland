package com.example.bookland.controller;

import com.example.bookland.domain.Author;
import com.example.bookland.domain.Book;
import com.example.bookland.repository.AuthorRepository;
import com.example.bookland.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;


    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @GetMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthorById(@PathVariable Integer id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Author not found with id = " + id));
        return author;
    }

    @PutMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author addBook(@PathVariable("id") Integer id, @RequestBody Book book){

        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));

        author.getBooks().add(book);
        return authorRepository.save(author);
    }




}
