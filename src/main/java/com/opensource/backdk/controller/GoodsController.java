package com.opensource.backdk.controller;

import com.opensource.backdk.domain.Goods;
import com.opensource.backdk.domain.Users;
import com.opensource.backdk.dto.CreateGoodsDto;
import com.opensource.backdk.dto.EditGoodsDto;
import com.opensource.backdk.service.GoodsService;
import com.opensource.backdk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class GoodsController {

    private final UserService userService;
    private final GoodsService goodsService;

    @GetMapping("/goodsList")
    public List<Goods> getGoodsList(){
        return goodsService.findAllGoods();
    }

    @GetMapping("/goods/{id}")
    public Goods getGoodsDetail(@PathVariable Long id ){
        return goodsService.findOneGoods(id);
    }

    @PostMapping("/goods/create")
    public Long createGoods(@RequestBody CreateGoodsDto dto, HttpServletRequest request) {
        Users user = userService.getCurrentUser(request);
        return goodsService.create(user.getUserId(), dto);
    }

    @PutMapping("/goods/{id}/edit")
    public void editGoods(@PathVariable Long id, @RequestBody EditGoodsDto dto,
                          HttpServletRequest request) throws IllegalAccessException {
        Users user = userService.getCurrentUser(request);
        goodsService.edit(id, dto, user.getUserId());
    }

    @DeleteMapping("/goods/{id}/remove")
    public void removeGoods(@PathVariable Long id, HttpServletRequest request)
            throws IllegalAccessException {
        Users user = userService.getCurrentUser(request);
        goodsService.remove(id, user.getUserId());
    }


}
