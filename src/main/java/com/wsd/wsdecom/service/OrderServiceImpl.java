package com.wsd.wsdecom.service;

import com.wsd.wsdecom.dto.TopSellingItemDto;
import com.wsd.wsdecom.repository.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;

  public OrderServiceImpl(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public List<TopSellingItemDto> getTopSellingItemsOfAllTime(int n) {
    Pageable top5 = PageRequest.of(0, n);
    return orderRepository.findTop5SellingItemsOfAllTime(top5);
  }
}
