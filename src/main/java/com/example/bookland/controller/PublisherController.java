package com.example.bookland.controller;

import com.example.bookland.domain.Publisher;
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
public class PublisherController {

    private PublisherRepository publisherRepository;
    private AuthorRepository authorRepository;


    @PostMapping("/publishers")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher savePublisher(@RequestBody Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @GetMapping("/publishers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher getPublisherById(@PathVariable Integer id) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Publisher not found with id = " + id));
        return publisher;
    }



}
