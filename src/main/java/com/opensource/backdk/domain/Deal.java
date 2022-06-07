package com.opensource.backdk.domain;

import com.opensource.backdk.dto.DealRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Deal {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String buyerId;

    @Column(nullable = false)
    private Long goodsId;

    public Deal(DealRequestDto dto) {
        this.buyerId = dto.getBuyerId();
        this.goodsId = dto.getGoodsId();
    }

    public Deal update(DealRequestDto dto) {
        this.buyerId = dto.getBuyerId();
        this.goodsId = dto.getGoodsId();
        return this;
    }

}
