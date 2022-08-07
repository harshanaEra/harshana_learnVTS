package com.fuelorderservice.service;

import com.fuelorderservice.doc.OrderRequest;

public interface OrderService {

    void createOrder(OrderRequest orderRequest);

    Object getOrder(String referenceId);

    Object getAllOrders();
}
