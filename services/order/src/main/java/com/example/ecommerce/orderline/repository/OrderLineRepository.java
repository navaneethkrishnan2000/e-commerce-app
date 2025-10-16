package com.example.ecommerce.orderline.repository;

import com.example.ecommerce.orderline.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {

    List<OrderLine> findAllByOrderId(Integer orderId);
}
