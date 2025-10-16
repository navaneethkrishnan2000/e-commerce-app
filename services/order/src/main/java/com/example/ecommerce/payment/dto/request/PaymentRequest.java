package com.example.ecommerce.payment.dto.request;

import com.example.ecommerce.customer.dto.request.CustomerResponse;
import com.example.ecommerce.order.model.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(

        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer

) {
}
