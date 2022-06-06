package com.opensource.backdk.repository;

import com.opensource.backdk.domain.Users;
import com.opensource.backdk.domain.WatchGoods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WatchGoodsRepository extends JpaRepository<WatchGoods, Long> {
    Optional<WatchGoods> findAllByUser(Users user);
}
