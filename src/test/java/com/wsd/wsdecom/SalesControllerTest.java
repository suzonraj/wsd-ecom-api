package com.wsd.wsdecom;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.wsd.wsdecom.dto.MaxSaleDayResponseDto;
import com.wsd.wsdecom.dto.TotalSalesResponseDto;
import com.wsd.wsdecom.service.SalesService;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class SalesControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private SalesService salesService;

  @Test
  void testGetTotalSalesTodayTest() throws Exception {
//    Test case for: GET request to /api/v1/sales/total-today
    TotalSalesResponseDto totalSalesResponseDto = TotalSalesResponseDto.builder().totalSales(new BigDecimal("16800.0")).build();

    when(salesService.getTotalSalesToday()).thenReturn(totalSalesResponseDto);

    mockMvc.perform(MockMvcRequestBuilders.get("/v1/sales/total-today"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.code").value(200))
        .andExpect(jsonPath("$.message").value("Success"))
        .andExpect(jsonPath("$.success").value(true))
        .andExpect(jsonPath("$.data.totalSales").value(totalSalesResponseDto.getTotalSales()));
  }

  @Test
  void testGetMaxSalesTodayTest() throws Exception {
//    Test case for: GET request to /api/v1/sales/max-sale-today
    MaxSaleDayResponseDto maxSaleDayResponseDto = MaxSaleDayResponseDto.builder().maxSaleDay(LocalDate.now().toString()).build();

    LocalDate today = LocalDate.now();

    when(salesService.getMaxSaleDay(today, today)).thenReturn(maxSaleDayResponseDto);

    mockMvc.perform(MockMvcRequestBuilders.get("/v1/sales/max-sale-day")
        .param("startDate", today.toString())
        .param("endDate", today.toString()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.code").value(200))
        .andExpect(jsonPath("$.message").value("Success"))
        .andExpect(jsonPath("$.success").value(true))
        .andExpect(jsonPath("$.data.maxSaleDay").value(maxSaleDayResponseDto.getMaxSaleDay()));
  }
}
