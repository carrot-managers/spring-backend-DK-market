package com.opensource.backdk.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class WatchGoods {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private Users user;

    @OneToOne
    @JoinColumn(name = "GOODS_ID", nullable = false)
    private Goods goods;

    public WatchGoods(Users user, Goods goods) {
        this.user = user;
        this.goods = goods;
    }

}
