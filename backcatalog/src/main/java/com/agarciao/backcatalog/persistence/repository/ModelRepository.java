package com.agarciao.backcatalog.persistence.repository;

import com.agarciao.backcatalog.persistence.entity.vehicle.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
}
