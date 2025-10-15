package com.example.ecommerce.customer.service.customer;

import com.example.ecommerce.customer.model.dto.request.CustomerRequest;
import com.example.ecommerce.customer.model.dto.response.CustomerResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface ICustomerService {

    String createCustomer(CustomerRequest request);

    void updateCustomer(@Valid CustomerRequest request);

    List<CustomerResponse> findAllCustomers();

    Boolean existsById(String customerId);

    CustomerResponse findById(String customerId);

    void deleteCustomer(String customerId);

}
