package com.opensource.backdk.service;

import com.opensource.backdk.domain.Goods;
import com.opensource.backdk.domain.Users;
import com.opensource.backdk.domain.WatchGoods;
import com.opensource.backdk.repository.GoodsRepository;
import com.opensource.backdk.repository.WatchGoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class WatchGoodsService {

    private final GoodsRepository goodsRepository;
    private final WatchGoodsRepository watchGoodsRepository;

    public Goods addWatchList(Users user, Long goodsId) {
        Goods goods = goodsRepository.findById(goodsId).orElseThrow(
                NullPointerException::new
        );

        WatchGoods watchGoods = new WatchGoods(user, goods);
        user.addWatchGoods(goods);
        watchGoodsRepository.save(watchGoods);
        return goods;
    }

    public List<Goods> getWatchList(Users user) {
        List<WatchGoods> watchList = user.getWatchList();

        List<Goods> goodsList = new ArrayList<>();
        for (WatchGoods watchGoods : watchList) {
            goodsList.add(watchGoods.getGoods());
        }
        
        return goodsList;
    }
}
