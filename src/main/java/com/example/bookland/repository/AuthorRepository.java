package com.example.bookland.repository;

import com.example.bookland.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query("select a.firstName,a.lastName " +
            "from Author a " +
            "inner join Publisher p " +
            "on a.authorId = p.publisherId " +
            "where p.publisherId = ?1")
    Author findAuthorByPublisherPublisherId(Long id);

    @Query("select a.firstName, a.country " +
            "from Author a " +
            "where a.authorId = ?1")
    Author getAuthorByFirstNameAndCountry(Integer id);

    @Query("select a.firstName, a.lastName, a.country " +
            "from Author a " +
            "where a.authorId = ?1")
    Author getAllFromAuthorById(Integer id);


}
