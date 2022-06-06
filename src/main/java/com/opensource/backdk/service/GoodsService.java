package com.opensource.backdk.service;

import com.opensource.backdk.domain.Goods;
import com.opensource.backdk.domain.Users;
import com.opensource.backdk.dto.CreateGoodsDto;
import com.opensource.backdk.dto.EditGoodsDto;
import com.opensource.backdk.repository.GoodsRepository;
import com.opensource.backdk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;


@Service
@RequiredArgsConstructor
public class GoodsService {


    private final GoodsRepository goodsRepository;
    private final UserRepository userRepository;

    public List<Goods> findAllGoods(){
        return goodsRepository.findAll();
    }

    public Goods findOneGoods(@PathVariable Long id){
        Goods goods = goodsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 상품입니다."));

        return goods;
    }

    @Transactional
    public Long create(String userId, CreateGoodsDto dto) {
        Users user = userRepository.findByUserId(userId).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다."));

        Goods goods = Goods.goods(user, dto);

        goodsRepository.save(goods);

        return goods.getGoodsId();
    }

    @Transactional
    public void remove(Long goodsId, String userId) throws IllegalAccessException {
        Goods goods = goodsRepository.findById(goodsId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 상품입니다.")
        );
        if (goods.getUser().getUserId().equals(userId)) {
            goodsRepository.delete(goods);
        }else{
            throw new IllegalAccessException("권한이 없습니다.");
        }
    }

    @Transactional
    public void edit(Long goodsId, EditGoodsDto dto, String userId) throws IllegalAccessException {
        Goods goods = goodsRepository.findById(goodsId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 상품입니다."));
        if (goods.getUser().getId().equals(userId)) {
            Goods.resetGoods(goods, dto);
        }else{
            throw new IllegalAccessException("권한이 없습니다.");
        }
    }
}
