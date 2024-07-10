package com.wsd.wsdecom.repository;

import com.wsd.wsdecom.entity.Sale;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
  @Query("SELECT COALESCE(SUM(s.amount), 0) FROM Sale s WHERE DATE(s.saleDate) = :date")
  BigDecimal getTotalSalesByDate(@Param("date") LocalDate date);
}
