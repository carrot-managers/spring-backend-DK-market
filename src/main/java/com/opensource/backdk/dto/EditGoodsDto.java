package com.opensource.backdk.dto;

import com.opensource.backdk.domain.GoodsStatus;
import lombok.Getter;

@Getter
public class EditGoodsDto {
    private String title;
    private String contents;
    private Long price;
    private GoodsStatus status;
}