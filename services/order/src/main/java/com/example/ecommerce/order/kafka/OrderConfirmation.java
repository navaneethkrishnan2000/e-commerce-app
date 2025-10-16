package com.example.ecommerce.order.kafka;

import com.example.ecommerce.customer.dto.request.CustomerResponse;
import com.example.ecommerce.order.model.PaymentMethod;
import com.example.ecommerce.product.dto.response.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(

        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {
}
