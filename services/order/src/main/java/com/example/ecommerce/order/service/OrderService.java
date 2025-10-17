package com.example.ecommerce.order.service;

import com.example.ecommerce.customer.client.CustomerClient;
import com.example.ecommerce.exception.BusinessException;
import com.example.ecommerce.order.kafka.OrderConfirmation;
import com.example.ecommerce.order.kafka.OrderProducer;
import com.example.ecommerce.order.mapper.OrderMapper;
import com.example.ecommerce.order.model.dto.request.OrderRequest;
import com.example.ecommerce.order.model.dto.request.PurchaseRequest;
import com.example.ecommerce.order.model.dto.response.OrderResponse;
import com.example.ecommerce.order.repository.OrderRepository;
import com.example.ecommerce.orderline.model.dto.request.OrderLineRequest;
import com.example.ecommerce.orderline.service.IOrderLineService;
import com.example.ecommerce.payment.client.PaymentClient;
import com.example.ecommerce.payment.dto.request.PaymentRequest;
import com.example.ecommerce.product.client.ProductClient;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final OrderMapper orderMapper;

    private final ProductClient productClient;
    private final PaymentClient paymentClient;
    private final CustomerClient customerClient;

    private final OrderRepository orderRepository;

    private final OrderProducer orderProducer;

    private final IOrderLineService orderLineService;

    @Override
    public Integer createOrder(OrderRequest request) {

        // Check for customer
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer exists with the provided ID: " + request.customerId()));

        // purchase the products
        var purchasedProducts = this.productClient.purchaseProducts(request.products());

        var order = this.orderRepository.save(orderMapper.toOrder(request));

        for (PurchaseRequest purchaseRequest : request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        // payment
        var paymentRequest = new PaymentRequest(
                request.amount(),
                request.paymentMethod(),
                order.getId(),
                order.getReference(),
                customer
        );
        paymentClient.requestOrderPayment(paymentRequest);

        // kafka
        orderProducer.sendOrderConfirmation(

                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        return order.getId();
    }

    public List<OrderResponse> findAllOrders() {
        return this.orderRepository.findAll()
                .stream()
                .map(this.orderMapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer id) {
        return this.orderRepository.findById(id)
                .map(this.orderMapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No order found with the provided ID: %d", id)));
    }
}
