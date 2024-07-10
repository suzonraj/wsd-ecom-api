package com.wsd.wsdecom.service;

import com.wsd.wsdecom.dto.TopSellingItemDto;
import java.util.List;

public interface OrderService {

  List<TopSellingItemDto> getTopSellingItemsOfAllTime(int n);
}
