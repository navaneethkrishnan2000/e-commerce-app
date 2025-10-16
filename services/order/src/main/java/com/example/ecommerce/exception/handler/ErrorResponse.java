package com.example.ecommerce.exception.handler;

import java.util.Map;

public record ErrorResponse (
        Map<String, Object> errors
){
}
