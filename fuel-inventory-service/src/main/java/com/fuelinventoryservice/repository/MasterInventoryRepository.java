package com.fuelinventoryservice.repository;

import com.fuelinventoryservice.common.FuelType;
import com.fuelinventoryservice.model.MasterInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterInventoryRepository extends JpaRepository<MasterInventory, String> {
    MasterInventory findByFuelType(FuelType fuelType);
}
