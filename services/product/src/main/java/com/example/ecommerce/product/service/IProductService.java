package com.example.ecommerce.product.service;

import com.example.ecommerce.product.model.dto.request.ProductPurchaseRequest;
import com.example.ecommerce.product.model.dto.request.ProductRequest;
import com.example.ecommerce.product.model.dto.response.ProductPurchaseResponse;
import com.example.ecommerce.product.model.dto.response.ProductResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface IProductService {
    
    Integer createProduct(@Valid ProductRequest request);

    List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request);

    ProductResponse findById(Integer productId);

    List<ProductResponse> findAll();
}
