package com.example.demo.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "askNo")
    private Ask askNo;
@Column(nullable = false)
    private String reply;
@Column(nullable = false)
    private LocalDateTime replyDate;

    public void update(String reply) {
        this.reply = reply;
    }

    public Long getCommentNo;

    public LocalDateTime getReplyDate;

    //getAskNo


}
