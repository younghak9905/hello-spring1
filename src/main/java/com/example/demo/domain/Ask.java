package com.example.demo.domain;

import com.example.demo.controller.AskForm;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Ask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String contents;
   // private Long writerNo;
    @Column(nullable = false)
    private String tags;
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "askNo", fetch = FetchType.LAZY)
    @OrderBy("commentNo asc")
    private List<Comment> comment = Collections.emptyList();



    public void update(String title, String contents, String tags) {
        this.title = title;
        this.contents = contents;
        this.tags = tags;
    }






    // private LocalDateTime createdDate;


}
