package com.example.ecommerce.customer.model.customer.dto.response;

import com.example.ecommerce.customer.model.Address;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email,
        Address address
) {
}
