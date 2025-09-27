package com.dev.ecom.controller;

import com.dev.ecom.payLoad.OrderDTO;
import com.dev.ecom.payLoad.OrderRequestDTO;
import com.dev.ecom.service.OrderService;
import com.dev.ecom.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ecom")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    AuthUtil authUtil;

    @PostMapping("/order/users/payments/{paymentMethod}")
    public ResponseEntity<OrderDTO> orderProducts(@PathVariable String paymentMethod,
                                                  @RequestBody OrderRequestDTO orderRequestDTO) {
        String emailId = authUtil.loggedInEmail();
        OrderDTO order = orderService.placeOrder(emailId, paymentMethod, orderRequestDTO);

        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }


}
