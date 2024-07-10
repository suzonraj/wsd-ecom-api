package com.wsd.wsdecom.service;

import com.wsd.wsdecom.dto.TotalSalesResponseDto;
import com.wsd.wsdecom.repository.SaleRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

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
}
