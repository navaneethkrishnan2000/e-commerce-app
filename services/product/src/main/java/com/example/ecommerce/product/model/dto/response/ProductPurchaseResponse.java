package com.example.ecommerce.product.model.dto.response;

import java.math.BigDecimal;

public record ProductPurchaseResponse(

        Integer productId,
        String name,
        String description,
        BigDecimal price,
        double quantity

) {
}
