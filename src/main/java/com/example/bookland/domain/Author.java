package com.example.bookland.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "author_id", nullable = false)
    private Long authorId;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    private String country;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Set<Book> books = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Set<Reward> rewards = new HashSet<>();


    @ManyToOne
    @JsonIgnore
    private Publisher publisher;

}
