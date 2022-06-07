package com.opensource.backdk.domain;

import javax.persistence.*;

@Entity
public class Deal {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private Users seller;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private Users buyer;

    @OneToOne
    @JoinColumn(name = "GOODS_ID", nullable = false)
    private Goods goodsId;
}
