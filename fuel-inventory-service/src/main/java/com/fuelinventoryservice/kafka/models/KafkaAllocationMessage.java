package com.fuelinventoryservice.kafka.models;

import com.fuelinventoryservice.common.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KafkaAllocationMessage {
    private String orderId;
    private Status status;
}
