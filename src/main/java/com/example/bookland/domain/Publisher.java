package com.example.bookland.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "publishers")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "publisher_id", nullable = false)
    private Integer publisherId;

    private String name;
    private String country;
    private String city;
    private String address;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    private Set<Author> authors = new HashSet<>();


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    private List<Reward> rewards = new ArrayList<>();

}
