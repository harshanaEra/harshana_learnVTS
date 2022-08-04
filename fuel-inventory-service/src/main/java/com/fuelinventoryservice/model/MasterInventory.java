package com.fuelinventoryservice.model;

import com.fuelinventoryservice.common.FuelCapacity;
import com.fuelinventoryservice.common.FuelType;
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
@Table(name = "master_inventory")
public class MasterInventory {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "fuel_type")
    @Enumerated
    private FuelType fuelType;

    @Column(name = "fuel_capacity")
    private Long fuelCapacity;

    @Column(name = "created_timeStamp")
    @CreationTimestamp
    private Timestamp createdTimeStamp;

    @Column(name = "updated_timeStamp")
    @UpdateTimestamp
    private Timestamp updatedTimestamp;
}
