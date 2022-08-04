package com.fuelorderservice.controller;


import com.fuelorderservice.common.ApiConstants;
import com.fuelorderservice.doc.OrderRequest;
import com.fuelorderservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = ApiConstants.CREATE_ORDER_API)
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest) {
        orderService.createOrder(orderRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = ApiConstants.GET_ORDER_API)
    public ResponseEntity<?> getOrder(@PathVariable("referenceId") String referenceId) {
        return ResponseEntity.ok(orderService.getOrder(referenceId));
    }

    @GetMapping(value = ApiConstants.ORDERS_API)
    public ResponseEntity<?> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

}

