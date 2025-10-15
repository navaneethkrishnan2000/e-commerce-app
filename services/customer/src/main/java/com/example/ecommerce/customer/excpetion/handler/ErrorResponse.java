package com.example.ecommerce.customer.excpetion.handler;

import java.util.Map;

public record ErrorResponse (
        Map<String, Object> errors
){
}
