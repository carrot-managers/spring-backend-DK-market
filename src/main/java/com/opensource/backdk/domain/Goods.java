package com.opensource.backdk.domain;

import com.opensource.backdk.dto.CreateGoodsDto;
import com.opensource.backdk.dto.EditGoodsDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Goods extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long goodsId;

    @Column(nullable = false)
    private Long price;

    @Enumerated(EnumType.STRING)
    private GoodsStatus status;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String authorId;

    public Goods(CreateGoodsDto dto, String userId) {
        this.price = dto.getPrice();
        this.status = GoodsStatus.SALE;
        this.title = dto.getTitle();
        this.contents = dto.getContents();
        this.authorId = userId;
    }

    public Goods resetGoods(EditGoodsDto dto){
        this.price = dto.getPrice();
//        this.status = dto.getStatus();
        this.title = dto.getTitle();
        this.contents = dto.getContents();
        return this;
    }

    public Goods toggleStatus() {
        if (this.status == GoodsStatus.SALE) {
            this.status = GoodsStatus.SOLD_OUT;
        } else {
            this.status = GoodsStatus.SALE;
        }
        return this;
    }
}
