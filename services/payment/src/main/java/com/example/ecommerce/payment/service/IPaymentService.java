package com.example.ecommerce.payment.service;

import com.example.ecommerce.payment.model.dto.request.PaymentRequest;

public interface IPaymentService {

    Integer createPayment(PaymentRequest request);
}
