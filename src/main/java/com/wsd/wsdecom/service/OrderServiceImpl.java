package com.wsd.wsdecom.service;

import com.wsd.wsdecom.dto.TopSellingItemDto;
import com.wsd.wsdecom.repository.OrderRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<TopSellingItemDto> getTopNSellingItemsOfAllTime(int n) {
        Pageable pageable = PageRequest.of(0, n);
        return orderRepository.findTopNSellingItemsOfAllTime(pageable);
    }

    @Override
    public List<TopSellingItemDto> getTop5SellingItemsOfLastMonth(int n) {
        LocalDateTime startOfMonth = LocalDate.now().minusMonths(1).withDayOfMonth(1).atStartOfDay();
        LocalDateTime endOfMonth = LocalDate.now().withDayOfMonth(1).minusDays(1).atTime(LocalTime.MAX);
        Pageable pageable = PageRequest.of(0, n);
        return orderRepository.findTop5SellingItemsOfLastMonth(startOfMonth, endOfMonth, pageable);
    }
}
