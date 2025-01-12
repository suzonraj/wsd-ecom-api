package com.wsd.wsdecom.controller;

import com.wsd.wsdecom.dto.MaxSaleDayResponseDto;
import com.wsd.wsdecom.dto.TotalSalesResponseDto;
import com.wsd.wsdecom.service.SalesService;
import com.wsd.wsdecom.util.response.ResponseCode;
import com.wsd.wsdecom.util.response.ResponseDto;
import com.wsd.wsdecom.util.response.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1")
public class SalesController {
    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/sales/total-today")
    public ResponseEntity<?> getTotalSalesToday() {
        ResponseDto<Object> response = new ResponseDto<>();
        TotalSalesResponseDto totalSalesResponseDto = salesService.getTotalSalesToday();

        response.setData(totalSalesResponseDto);
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setMessage(ResponseCode.SUCCESS.getMessage());
        response.setSuccess(true);


        return ResponseUtil.response(response);
    }

    @GetMapping("/sales/max-sale-day")
    public ResponseEntity<?> getMaxSaleToday(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        ResponseDto<Object> response = new ResponseDto<>();
        MaxSaleDayResponseDto maxSaleDayResponseDto = salesService.getMaxSaleDay(startDate, endDate);

        response.setData(maxSaleDayResponseDto);
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setMessage(ResponseCode.SUCCESS.getMessage());
        response.setSuccess(true);


        return ResponseUtil.response(response);
    }


}
