package com.example.bookland.resource;


import com.example.bookland.domain.Author;
import com.example.bookland.domain.Book;
import com.example.bookland.repository.AuthorRepository;
import com.example.bookland.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AuthorResource {

    private final AuthorRepository authorRepository;
    private final AuthorService authorService;

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author author) {
        return authorService.saveBookAuthor(author);
    }

    @GetMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthorById(@PathVariable Integer id) {
        return authorService.findBookAuthorById(id);
    }

    @PutMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    //@Transactional
    public Author addBook(@PathVariable("id") Integer id, @RequestBody Book book) {

        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Author not found with id = " + id));

        author.getBooks().add(book);
        return authorRepository.save(author);
    }

    @GetMapping("/authors/publishers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthorByPublisherId(@PathVariable("id") Long id) {

        return authorRepository.findAuthorByPublisherPublisherId(id);

    }

    @GetMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthorByFirstNameAndCountry(@PathVariable Integer id){
        return authorRepository.getAuthorByFirstNameAndCountry(id);
    }

    @GetMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAllFromAuthorById(@PathVariable Integer id){
        return authorRepository.getAllFromAuthorById(id);
    }


}
