package com.example.ecommerce.customer.dto.request;

public record CustomerResponse(

        String id,
        String firstName,
        String lastName,
        String email
) {
}
