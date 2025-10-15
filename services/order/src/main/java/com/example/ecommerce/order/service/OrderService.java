package com.example.ecommerce.order.service;

import com.example.ecommerce.customer.client.CustomerClient;
import com.example.ecommerce.exception.BusinessException;
import com.example.ecommerce.order.model.dto.request.OrderRequest;
import com.example.ecommerce.order.model.dto.response.OrderResponse;
import com.example.ecommerce.order.repository.OrderRepository;
import com.example.ecommerce.product.client.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final ProductClient productClient;
    private final CustomerClient customerClient;
    private final OrderRepository orderRepository;

    @Override
    public Integer createOrder(OrderRequest request) {

        // Check for customer
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer exists with the provided ID: " + request.customerId()));

        // purchase the products

    }

    @Override
    public List<OrderResponse> findAllOrders() {
        return List.of();
    }

    @Override
    public OrderResponse findById(Integer orderId) {
        return null;
    }
}
