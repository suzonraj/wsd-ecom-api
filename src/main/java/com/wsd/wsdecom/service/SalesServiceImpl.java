package com.wsd.wsdecom.service;

import com.wsd.wsdecom.dto.MaxSaleDayResponseDto;
import com.wsd.wsdecom.dto.TotalSalesResponseDto;
import com.wsd.wsdecom.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class SalesServiceImpl implements SalesService {

    private final SaleRepository salesRepository;

    public SalesServiceImpl(SaleRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    @Override
    public TotalSalesResponseDto getTotalSalesToday() {
        BigDecimal totalSales = salesRepository.getTotalSalesByDate(LocalDate.now());
        totalSales = totalSales != null ? totalSales : BigDecimal.ZERO;

        return TotalSalesResponseDto.builder().totalSales(totalSales).build();
    }

    @Override
    public MaxSaleDayResponseDto getMaxSaleDay(LocalDate startDate, LocalDate endDate) {
        LocalDateTime maxSaleDate = salesRepository.getMaxSaleDateInRange(startDate.atStartOfDay(), LocalDateTime.of(endDate, LocalTime.MAX));
        return MaxSaleDayResponseDto.builder().maxSaleDay(maxSaleDate.toString()).build();
    }
}
