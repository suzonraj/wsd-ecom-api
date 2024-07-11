package com.wsd.wsdecom.service;

import com.wsd.wsdecom.dto.MaxSaleDayResponseDto;
import com.wsd.wsdecom.dto.TotalSalesResponseDto;

import java.time.LocalDate;

public interface SalesService {
    TotalSalesResponseDto getTotalSalesToday();

    MaxSaleDayResponseDto getMaxSaleDay(LocalDate startDate, LocalDate endDate);
}
