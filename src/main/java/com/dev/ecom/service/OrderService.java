package com.dev.ecom.service;

import com.dev.ecom.payLoad.OrderDTO;
import com.dev.ecom.payLoad.OrderRequestDTO;
import jakarta.transaction.Transactional;

public interface OrderService {
    @Transactional
    OrderDTO placeOrder(String emailId, String paymentMethod, OrderRequestDTO orderRequestDTO);
}
