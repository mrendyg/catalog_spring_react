package com.agarciao.backcatalog.persistence.repository;

import com.agarciao.backcatalog.persistence.entity.vehicle.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {
}
