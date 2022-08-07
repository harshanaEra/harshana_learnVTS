package com.fuelorderservice.service;

import com.fuelorderservice.doc.OrderRequest;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Value("${app.config.order-topic}")
    private String orderTopic;

    final KafkaTemplate<String, String> kafkaTemplate;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public OrderServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void createOrder(OrderRequest orderRequest) {
        log.info("[ORDER-SERVICE] : creating the order and request is {}", orderRequest);
        kafkaTemplate.send(orderTopic, new Gson().toJson(orderRequest));
    }

    @Override
    public Object getOrder(String referenceId) {
        log.info("[ORDER-SERVICE] : getting the order and reference id {}", referenceId);
        return null;
    }

    @Override
    public Object getAllOrders() {
        log.info("[ORDER-SERVICE] : getting the all orders");
        return null;
    }

}
