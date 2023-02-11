package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private String name;
    private String email;
    private String password;

    private String id;

    private String github;

    private String blog;

    private Long score;
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Ask> ask = Collections.emptyList();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Comment> comment = Collections.emptyList();

    //MemberStat answerCount,askCount,score




}
