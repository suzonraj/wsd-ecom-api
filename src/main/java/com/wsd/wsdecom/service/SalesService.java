package com.wsd.wsdecom.service;

import com.wsd.wsdecom.dto.TotalSalesResponseDto;
import java.math.BigDecimal;

public interface SalesService {
  TotalSalesResponseDto getTotalSalesToday();
}
