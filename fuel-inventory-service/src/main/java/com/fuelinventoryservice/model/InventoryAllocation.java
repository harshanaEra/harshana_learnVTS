package com.fuelinventoryservice.model;

import com.fuelinventoryservice.common.FuelCapacity;
import com.fuelinventoryservice.common.FuelType;
import com.fuelinventoryservice.common.Status;
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
@Table(name = "inventory_allocation")
public class InventoryAllocation {
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

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "created_timeStamp")
    @CreationTimestamp
    private Timestamp createdTimeStamp;

    @Column(name = "updated_timeStamp")
    @UpdateTimestamp
    private Timestamp updatedTimestamp;
}
