package com.wsd.wsdecom.controller;

import com.wsd.wsdecom.dto.MaxSaleDayResponseDto;
import com.wsd.wsdecom.dto.TopSellingItemDto;
import com.wsd.wsdecom.dto.TotalSalesResponseDto;
import com.wsd.wsdecom.service.OrderService;
import com.wsd.wsdecom.service.SalesService;
import com.wsd.wsdecom.util.response.ResponseCode;
import com.wsd.wsdecom.util.response.ResponseDto;
import com.wsd.wsdecom.util.response.ResponseUtil;
import java.time.LocalDate;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class OrderController {
  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping("/orders/top-all-time")
  public ResponseEntity<?> getTopSellingItemsOfAllTime(@RequestParam("n") int n) {
    ResponseDto<Object> response = new ResponseDto<>();
    List<TopSellingItemDto> topSellingItems = orderService.getTopSellingItemsOfAllTime(n);

    response.setData(topSellingItems);
    response.setCode(ResponseCode.SUCCESS.getCode());
    response.setMessage(ResponseCode.SUCCESS.getMessage());
    response.setSuccess(true);


    return ResponseUtil.response(response);
  }


}
