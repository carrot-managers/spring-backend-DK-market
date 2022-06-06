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
import javax.servlet.http.HttpSession;
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
    public Goods createGoods(@RequestBody CreateGoodsDto dto, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");

        return goodsService.create(user.getUserId(), dto);
    }

    @PutMapping("/goods/{goodsId}/edit")
    public Goods editGoods(@PathVariable Long goodsId, @RequestBody EditGoodsDto dto,
                          HttpServletRequest request) throws IllegalAccessException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");

        return goodsService.edit(goodsId, dto, user.getUserId());
    }

    @PutMapping("/goods/{id}/edit/status")
    public Goods toggleStatus(@PathVariable Long id, HttpServletRequest request) throws IllegalAccessException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");

        return goodsService.toggleStatus(id, user.getUserId());
    }

    @DeleteMapping("/goods/{id}/remove")
    public void removeGoods(@PathVariable Long id, HttpServletRequest request)
            throws IllegalAccessException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");

        goodsService.remove(id, user.getUserId());
    }


}
