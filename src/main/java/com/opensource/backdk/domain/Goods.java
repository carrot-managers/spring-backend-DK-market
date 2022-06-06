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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private Users user;

    private LocalDateTime registeredDate;

    public void setUser(Users user) {
        this.user = user;
        user.getGoodsList().add(this);
    }

    public static Goods goods(Users user, CreateGoodsDto dto) {
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
