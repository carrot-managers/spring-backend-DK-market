package com.opensource.backdk.domain;

import com.opensource.backdk.dto.CreateGoodsDto;
import com.opensource.backdk.dto.EditGoodsDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@Entity
public class Goods {

    @Id
    @Column(name = "goods_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long price;

    @Enumerated(EnumType.STRING)
    private GoodsStatus status;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    private LocalDateTime registeredDate;

    public void setUser(User user) {
        this.user = user;
        user.getGoodsList().add(this);
    }

    public static Goods goods(User user, CreateGoodsDto dto) {
        Goods goods = new Goods();
        goods.setUser(user);
        goods.setStatus(GoodsStatus.SALE);
        goods.setRegisteredDate(LocalDateTime.now());
        goods.setContents(dto.getContents());
        goods.setPrice(dto.getPrice());
        goods.setTitle(dto.getTitle());

        return goods;
    }
    public static void resetGoods(Goods goods, EditGoodsDto dto){
        goods.setTitle(dto.getTitle());
        goods.setContents(dto.getContents());
        goods.setPrice(dto.getPrice());
        goods.setStatus(dto.getStatus());
    }
}
