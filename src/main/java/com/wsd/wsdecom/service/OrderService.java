package com.wsd.wsdecom.service;

import com.wsd.wsdecom.dto.TopSellingItemDto;

import java.util.List;

public interface OrderService {

    List<TopSellingItemDto> getTopNSellingItemsOfAllTime(int n);

    List<TopSellingItemDto> getTop5SellingItemsOfLastMonth(int n);
}
