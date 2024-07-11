package com.wsd.wsdecom.repository;

import com.wsd.wsdecom.dto.TopSellingItemDto;
import com.wsd.wsdecom.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT new com.wsd.wsdecom.dto.TopSellingItemDto(op.item.id, op.item.name, SUM(op.price * op.quantity), SUM(op.quantity)) " +
            "FROM OrderItem op GROUP BY op.item.id, op.item.name ORDER BY SUM(op.price * op.quantity) DESC")
    List<TopSellingItemDto> findTopNSellingItemsOfAllTime(Pageable pageable);

    @Query("SELECT new com.wsd.wsdecom.dto.TopSellingItemDto(op.item.id, op.item.name, SUM(op.price * op.quantity), SUM(op.quantity)) " +
            "FROM OrderItem op WHERE op.order.orderDate >= :startDate AND op.order.orderDate <= :endDate " +
            "GROUP BY op.item.id, op.item.name ORDER BY SUM(op.quantity) DESC")
    List<TopSellingItemDto> findTop5SellingItemsOfLastMonth(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, Pageable pageable);
}
