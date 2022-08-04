package com.fuelscheduleservice.kafka.models;

import com.fuelscheduleservice.common.FuelCapacity;
import com.fuelscheduleservice.common.FuelType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KafkaOrderMessage {
    private String orderId;
    private FuelType fuelType;
    private FuelCapacity fuelCapacity;
}
