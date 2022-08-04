package com.fuelinventoryservice.repository;

import com.fuelinventoryservice.model.InventoryAllocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryAllocationRepository extends JpaRepository<InventoryAllocation, String> {
}
