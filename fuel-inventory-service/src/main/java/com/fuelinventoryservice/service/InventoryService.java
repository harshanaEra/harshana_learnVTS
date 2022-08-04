package com.fuelinventoryservice.service;

import com.fuelinventoryservice.common.Status;
import com.fuelinventoryservice.kafka.models.KafkaAllocationMessage;
import com.fuelinventoryservice.kafka.models.KafkaOrderMessage;
import com.fuelinventoryservice.model.MasterInventory;
import com.fuelinventoryservice.repository.MasterInventoryRepository;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InventoryService {

    @Value("${app.config.allocation-topic}")
    private String allocationTopic;

    final KafkaTemplate<String, String> kafkaTemplate;

    final MasterInventoryRepository masterInventoryRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public InventoryService(KafkaTemplate<String, String> kafkaTemplate,
                            MasterInventoryRepository masterInventoryRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.masterInventoryRepository = masterInventoryRepository;
    }

    @KafkaListener(topics = {"OrderTopic"}, groupId = "spring-boot-kafka")
    public void consumeOrders(String message) {
        KafkaOrderMessage kafkaOrderMessage = new Gson().fromJson(message, KafkaOrderMessage.class);
        MasterInventory masterInventory = masterInventoryRepository.findByFuelType(kafkaOrderMessage.getFuelType());
        if (masterInventory.getFuelCapacity() > kafkaOrderMessage.getFuelCapacity().getCapacity()) {
            kafkaTemplate.send(allocationTopic, new Gson().toJson(new KafkaAllocationMessage(kafkaOrderMessage.getOrderId(), Status.ALLOCATED)));
            masterInventory.setFuelCapacity(masterInventory.getFuelCapacity() - kafkaOrderMessage.getFuelCapacity().getCapacity());
            masterInventoryRepository.save(masterInventory);
        } else {
            kafkaTemplate.send(allocationTopic, new Gson().toJson(new KafkaAllocationMessage(kafkaOrderMessage.getOrderId(), Status.NOT_ALLOCATED)));
        }
    }
}
