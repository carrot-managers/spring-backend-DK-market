package com.opensource.backdk.controller;

import com.opensource.backdk.domain.Goods;
import com.opensource.backdk.domain.Users;
import com.opensource.backdk.service.WatchGoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class WatchGoodsController {

    private final WatchGoodsService watchGoodsService;

    @PostMapping("/watch/lists/{goodsId}")
    public Goods addWatchList(HttpServletRequest request, @PathVariable Long goodsId) {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");

        return watchGoodsService.addWatchList(user, goodsId);
    }

    @GetMapping("/watch/lists")
    public List<Goods> getWatchList(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");

        return watchGoodsService.getWatchList(user);
    }

}
