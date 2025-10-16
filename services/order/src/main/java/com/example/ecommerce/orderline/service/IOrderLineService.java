package com.example.ecommerce.orderline.service;

import com.example.ecommerce.orderline.model.dto.request.OrderLineRequest;
import com.example.ecommerce.orderline.model.dto.response.OrderLineResponse;

import java.util.List;

public interface IOrderLineService {

    Integer saveOrderLine(OrderLineRequest orderLineRequest);

    List<OrderLineResponse> findAllByOrderId(Integer orderId);
}
