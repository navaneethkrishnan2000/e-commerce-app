package com.example.ecommerce.orderline.mapper;

import com.example.ecommerce.order.model.Order;
import com.example.ecommerce.orderline.model.OrderLine;
import com.example.ecommerce.orderline.model.dto.request.OrderLineRequest;
import com.example.ecommerce.orderline.model.dto.response.OrderLineResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {

    public OrderLine toOrderLine(OrderLineRequest orderLineRequest) {
        return OrderLine.builder()
                .id(orderLineRequest.id())
                .productId(orderLineRequest.productId())
                .quantity(orderLineRequest.quantity())
                .order(
                        Order.builder()
                                .id(orderLineRequest.orderId())
                                .build()
                )
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(
                orderLine.getId(),
                orderLine.getQuantity()
        );
    }
}
