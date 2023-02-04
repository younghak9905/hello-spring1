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
//selected='1' 이면 채택
    @Column
    private String selected;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ask_No")
    private Ask ask;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_No")
    private Member member;

    public void update(Long commentGroup) {
        this.commentGroup = commentGroup;
    }

    public void edit(String reply) {
        this.reply = reply;
    }



}
