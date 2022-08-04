package com.fuelscheduleservice.kafka.models;

import com.fuelscheduleservice.common.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class KafkaScheduledMessage {
    private String orderId;
    private Status status;
    private Timestamp scheduledDate;
}
