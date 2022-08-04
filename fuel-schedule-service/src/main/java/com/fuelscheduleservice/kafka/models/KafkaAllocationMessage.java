package com.fuelscheduleservice.kafka.models;

import com.fuelscheduleservice.common.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KafkaAllocationMessage {
    private String orderId;
    private Status status;
}
