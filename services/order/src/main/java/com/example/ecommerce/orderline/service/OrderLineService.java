package com.example.ecommerce.orderline.service;

import com.example.ecommerce.orderline.mapper.OrderLineMapper;
import com.example.ecommerce.orderline.model.dto.request.OrderLineRequest;
import com.example.ecommerce.orderline.model.dto.response.OrderLineResponse;
import com.example.ecommerce.orderline.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderLineService implements IOrderLineService {

    private final OrderLineMapper orderLineMapper;
    private final OrderLineRepository orderLineRepository;

    @Override
    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        var order = orderLineMapper.toOrderLine(orderLineRequest);
        return orderLineRepository.save(order).getId();
    }

    @Override
    public List<OrderLineResponse> findAllByOrderId(Integer orderId) {
        return orderLineRepository.findAllByOrderId(orderId)
                .stream()
                .map(orderLineMapper::toOrderLineResponse)
                .collect(Collectors.toList());
    }
}
