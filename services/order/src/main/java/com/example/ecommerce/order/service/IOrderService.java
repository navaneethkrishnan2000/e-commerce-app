package com.example.ecommerce.order.service;

import com.example.ecommerce.order.model.dto.request.OrderRequest;
import com.example.ecommerce.order.model.dto.response.OrderResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface IOrderService {

    Integer createOrder(@Valid OrderRequest request);

    List<OrderResponse> findAllOrders();

    OrderResponse findById(Integer orderId);
}
