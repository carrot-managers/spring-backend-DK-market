package com.opensource.backdk.controller;

import com.opensource.backdk.domain.Deal;
import com.opensource.backdk.dto.DealRequestDto;
import com.opensource.backdk.service.DealService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DealController {

    private final DealService dealService;

    @PostMapping("/deal/create")
    public Deal createDeal(@RequestBody DealRequestDto dto) {
        return dealService.createDeal(dto);
    }

    @GetMapping("/deal")
    public List<Deal> getAllDealList() {
        return dealService.getAllDealList();
    }

    @GetMapping("/deal/{dealId}")
    public Deal getDeal(@PathVariable Long dealId) {
        return dealService.getDeal(dealId);
    }

    @DeleteMapping("/deal/{dealId}")
    public void deleteDeal(@PathVariable Long dealId) {
        dealService.deleteDeal(dealId);
    }
}
