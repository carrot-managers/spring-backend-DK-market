package com.opensource.backdk.service;

import com.opensource.backdk.domain.Deal;
import com.opensource.backdk.dto.DealRequestDto;
import com.opensource.backdk.repository.DealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DealService {

    private final DealRepository dealRepository;

    @Transactional
    public Deal createDeal(DealRequestDto dto) {
        Deal deal = new Deal(dto);
        return dealRepository.save(deal);
    }

    public List<Deal> getAllDealList() {
        return dealRepository.findAll();
    }

    public Deal getDeal(Long dealId) {
        return dealRepository.findById(dealId).orElseThrow(
                () -> new NullPointerException("해당하는 거래가 존재하지 않습니다.")
        );
    }

    @Transactional
    public Deal updateDeal(Long dealId, DealRequestDto dto) {
        Deal deal = dealRepository.findById(dealId).orElseThrow(
                () -> new NullPointerException("해당하는 거래가 존재하지 않습니다.")
        );

        deal.update(dto);
        return deal;
    }

    @Transactional
    public void deleteDeal(Long dealId) {
        dealRepository.deleteById(dealId);
    }
}
