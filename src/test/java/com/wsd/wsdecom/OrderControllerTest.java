package com.wsd.wsdecom;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.wsd.wsdecom.dto.TopSellingItemDto;
import com.wsd.wsdecom.service.OrderService;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private OrderService orderService;

  @Test
  public void testGetTop5SellingItemsOfAllTimeTest() throws Exception {
    List<TopSellingItemDto> topSellingItems = Arrays.asList(
        new TopSellingItemDto(2L, "Laptop", new BigDecimal("22500.00"), 3L),
        new TopSellingItemDto(1L, "Google pixel 9 pro", new BigDecimal("2600.00"), 2L),
        new TopSellingItemDto(3L, "Smartphone", new BigDecimal("700.00"), 1L)
    );

    when(orderService.getTopNSellingItemsOfAllTime(5)).thenReturn(topSellingItems);

    mockMvc.perform(get("/v1/orders/top-all-time")
            .param("n", "5"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.code").value(200))
        .andExpect(jsonPath("$.message").value("Success"))
        .andExpect(jsonPath("$.success").value(true))
        .andExpect(jsonPath("$.data[0].itemId").value(2))
        .andExpect(jsonPath("$.data[0].itemName").value("Laptop"))
        .andExpect(jsonPath("$.data[0].totalSalesAmount").value(22500))
        .andExpect(jsonPath("$.data[0].totalSalesQuantity").value(3))
        .andExpect(jsonPath("$.data[1].itemId").value(1))
        .andExpect(jsonPath("$.data[1].itemName").value("Google pixel 9 pro"))
        .andExpect(jsonPath("$.data[1].totalSalesAmount").value(2600))
        .andExpect(jsonPath("$.data[1].totalSalesQuantity").value(2))
        .andExpect(jsonPath("$.data[2].itemId").value(3))
        .andExpect(jsonPath("$.data[2].itemName").value("Smartphone"))
        .andExpect(jsonPath("$.data[2].totalSalesAmount").value(700))
        .andExpect(jsonPath("$.data[2].totalSalesQuantity").value(1));
  }

  @Test
  public void testGetTop5SellingItemsOfLastMonthTest() throws Exception {
    List<TopSellingItemDto> topSellingItems = Arrays.asList(
        new TopSellingItemDto(1L, "Google pixel 9 pro", new BigDecimal("3300.00"), 2L),
        new TopSellingItemDto(2L, "Laptop", new BigDecimal("4500.00"), 1L),
        new TopSellingItemDto(3L, "Smartphone", new BigDecimal("700.00"), 1L),
        new TopSellingItemDto(4L, "Headphones", new BigDecimal("700.00"), 1L)
    );

    when(orderService.getTop5SellingItemsOfLastMonth(5)).thenReturn(topSellingItems);

    mockMvc.perform(get("/v1/orders/top-last-month")
            .param("n", "5"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.code").value(200))
        .andExpect(jsonPath("$.message").value("Success"))
        .andExpect(jsonPath("$.success").value(true))
        .andExpect(jsonPath("$.data[0].itemId").value(1))
        .andExpect(jsonPath("$.data[0].itemName").value("Google pixel 9 pro"))
        .andExpect(jsonPath("$.data[0].totalSalesAmount").value(3300))
        .andExpect(jsonPath("$.data[0].totalSalesQuantity").value(2))
        .andExpect(jsonPath("$.data[1].itemId").value(2))
        .andExpect(jsonPath("$.data[1].itemName").value("Laptop"))
        .andExpect(jsonPath("$.data[1].totalSalesAmount").value(4500))
        .andExpect(jsonPath("$.data[1].totalSalesQuantity").value(1))
        .andExpect(jsonPath("$.data[2].itemId").value(3))
        .andExpect(jsonPath("$.data[2].itemName").value("Smartphone"))
        .andExpect(jsonPath("$.data[2].totalSalesAmount").value(700))
        .andExpect(jsonPath("$.data[2].totalSalesQuantity").value(1))
        .andExpect(jsonPath("$.data[3].itemId").value(4))
        .andExpect(jsonPath("$.data[3].itemName").value("Headphones"))
        .andExpect(jsonPath("$.data[3].totalSalesAmount").value(700))
        .andExpect(jsonPath("$.data[3].totalSalesQuantity").value(1));
  }
}
