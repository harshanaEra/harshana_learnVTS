package com.fuelorderservice.doc;

import com.fuelorderservice.common.FuelCapacity;
import com.fuelorderservice.common.FuelType;
import lombok.Data;

import javax.persistence.Enumerated;

@Data
public class OrderRequest {
    private String fuelStationId;
    @Enumerated
    private FuelType fuelType;
    @Enumerated
    private FuelCapacity fuelCapacity;
}
