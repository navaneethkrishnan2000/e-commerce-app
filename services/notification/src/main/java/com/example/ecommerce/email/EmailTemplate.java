package com.example.ecommerce.email;

import lombok.Getter;

public enum EmailTemplate {
    PAYMENT_CONFIRMATAION("payment-confirmation.html", "Payment successfully processed"),
    ORDER_CONFIRMATAION("templates/order-confirmation.html", "Order confirmation");

    @Getter private final String template;
    @Getter private final String subject;

    EmailTemplate(String template, String subject) {
        this.template = template;
        this.subject = subject;
    }
}
