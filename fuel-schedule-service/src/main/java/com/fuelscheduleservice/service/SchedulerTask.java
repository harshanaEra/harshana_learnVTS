package com.fuelscheduleservice.service;

import com.fuelscheduleservice.common.Status;
import com.fuelscheduleservice.kafka.models.KafkaOrderMessage;
import com.fuelscheduleservice.kafka.models.KafkaScheduledMessage;
import com.fuelscheduleservice.model.FuelOrder;
import com.fuelscheduleservice.repository.FuelOrderRepository;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Slf4j
@Service
public class SchedulerTask {
    @Value("${app.config.scheduled-topic}")
    private String scheduledTopic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final FuelOrderRepository fuelOrderRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public SchedulerTask(KafkaTemplate<String, String> kafkaTemplate, FuelOrderRepository fuelOrderRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.fuelOrderRepository = fuelOrderRepository;
    }

    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        log.info("Fixed delay task - {}", System.currentTimeMillis() / 1000);
        List<FuelOrder> fuelOrders = fuelOrderRepository.findAllByStatus(Status.SCHEDULED);
        if (!fuelOrders.isEmpty()) {
            for (FuelOrder fuelOrder : fuelOrders) {
                KafkaScheduledMessage kafkaScheduledMessage = new KafkaScheduledMessage(
                        fuelOrder.getId(), Status.SCHEDULED, Timestamp.from(Instant.now()));
                kafkaTemplate.send(scheduledTopic, new Gson().toJson(kafkaScheduledMessage));
            }
        }
    }
}
