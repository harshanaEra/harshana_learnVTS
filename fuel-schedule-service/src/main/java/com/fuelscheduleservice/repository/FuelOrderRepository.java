package com.fuelscheduleservice.repository;

import com.fuelscheduleservice.common.Status;
import com.fuelscheduleservice.model.FuelOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuelOrderRepository extends JpaRepository<FuelOrder, String> {


    List<FuelOrder> findAllByStatus(Status status);

}
