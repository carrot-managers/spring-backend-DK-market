package com.opensource.backdk.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opensource.backdk.dto.AddCommentDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String userId;

    @ManyToOne
    @JoinColumn(name = "GOODS_ID", nullable = false)
    @JsonIgnore
    private Goods goods;

    @Column(nullable = false)
    private String contents;

    public Comment(AddCommentDto dto, String userId, Goods goods) {
        this.contents = dto.getContents();
        this.userId = userId;
        this.goods = goods;
    }
}
