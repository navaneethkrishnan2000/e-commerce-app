package com.example.ecommerce.payment.service;

import com.example.ecommerce.notification.NotificationProducer;
import com.example.ecommerce.notification.PaymentNotificationRequest;
import com.example.ecommerce.payment.mapper.PaymentMapper;
import com.example.ecommerce.payment.model.dto.request.PaymentRequest;
import com.example.ecommerce.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService {

    private final PaymentMapper paymentMapper;
    private final PaymentRepository paymentRepository;
    private final NotificationProducer notificationProducer;

    @Override
    public Integer createPayment(PaymentRequest request) {

        var payment = paymentRepository.save(paymentMapper.toPayment(request));

        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstname(),
                        request.customer().lastname(),
                        request.customer().email()
                )
        );

        return payment.getId();
    }
}
