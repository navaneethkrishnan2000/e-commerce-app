package com.example.ecommerce.excpetion.handler;

import java.util.Map;

public record ErrorResponse (
        Map<String, Object> errors
){
}
