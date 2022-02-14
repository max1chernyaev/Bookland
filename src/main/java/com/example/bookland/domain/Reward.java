package com.example.bookland.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "rewards")
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "reward_id", nullable = false)
    private Integer rewardId;

    private String name;
    private String description;


    @ManyToOne
    private Author author;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Publisher publisher;
}
