package com.fuelscheduleservice.model;

import com.fuelscheduleservice.common.FuelCapacity;
import com.fuelscheduleservice.common.FuelType;
import com.fuelscheduleservice.common.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Entity
@Table(name = "fuel_order")
public class FuelOrder {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "fuel_type")
    @Enumerated
    private FuelType fuelType;

    @Column(name = "fuel_capacity")
    @Enumerated
    private FuelCapacity fuelCapacity;

    @Column(name = "fuel_station_id")
    private String fuelStationId;

    @Column(name = "status")
    @Enumerated
    private Status status;

    @Column(name = "order_date")
    @CreationTimestamp
    private Timestamp orderDate;

    @Column(name = "updated_date")
    @UpdateTimestamp
    private Timestamp updatedDate;

    @Column(name = "allocation_date")
    private Timestamp allocationDate;

    @Column(name = "scheduled_date")
    private Timestamp scheduleDate;

    @Column(name = "dispatch_date")
    private Timestamp dispatchDate;

    @Column(name = "driver_id")
    private String driverId;
}
