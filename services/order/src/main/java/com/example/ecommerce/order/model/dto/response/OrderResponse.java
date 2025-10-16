package com.example.ecommerce.order.model.dto.response;

import com.example.ecommerce.order.model.PaymentMethod;

import java.math.BigDecimal;

public record OrderResponse(

        Integer id,
        String reference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerId

) {
}
