package com.wsd.wsdecom.repository;

import com.wsd.wsdecom.dto.TopSellingItemDto;
import com.wsd.wsdecom.entity.Order;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

  @Query("SELECT new com.wsd.wsdecom.dto.TopSellingItemDto(op.item.id, op.item.name, SUM(op.price * op.quantity), SUM(op.quantity)) " +
      "FROM OrderItem op GROUP BY op.item.id, op.item.name ORDER BY SUM(op.price * op.quantity) DESC")
  List<TopSellingItemDto> findTop5SellingItemsOfAllTime(Pageable pageable);
}
