package com.fuelinventoryservice.kafka.models;

import com.fuelinventoryservice.common.FuelCapacity;
import com.fuelinventoryservice.common.FuelType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KafkaOrderMessage {
    private String orderId;
    private FuelType fuelType;
    private FuelCapacity fuelCapacity;
}
