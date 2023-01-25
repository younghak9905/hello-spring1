package com.example.demo.domain;


import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_no")
    private Long commentNo;

    @Column(nullable = false)
    private String reply;

    @Column(name="reply_Date")
    private String replyDate;
//commentNo=commentGroup
    @Column(name="comment_group")
    private Long commentGroup;

    @Column(nullable = true)
    private Long depth;


    @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "ask_No")
    private Ask ask;

    public void update(Long commentGroup) {
        this.commentGroup = commentGroup;
    }



}
