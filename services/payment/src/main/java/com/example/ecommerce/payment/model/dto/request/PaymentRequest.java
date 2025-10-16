package com.example.ecommerce.payment.model.dto.request;

import com.example.ecommerce.customer.model.Customer;
import com.example.ecommerce.payment.model.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        Customer customer
) {
}
