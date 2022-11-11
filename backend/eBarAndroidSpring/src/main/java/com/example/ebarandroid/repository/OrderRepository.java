package com.example.ebarandroid.repository;


import com.example.ebarandroid.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderModel,Long> {
    @Query(nativeQuery = true, value = "SELECT o.* FROM `order` o  WHERE o.table_id = :table_id AND o.status = 'active'")
    List<OrderModel> getOrderForTableId(@Param("table_id")int table_id);
}
