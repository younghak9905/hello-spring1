package com.example.demo.domain;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(columnDefinition="TEXT",nullable = false)
    private String commment;

    private String modifeidDate;
    @ManyToOne
    @JoinColumn(name = "ask_no")
    private Ask posts;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member member;

}
