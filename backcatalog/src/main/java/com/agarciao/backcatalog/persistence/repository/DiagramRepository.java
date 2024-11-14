package com.agarciao.backcatalog.persistence.repository;

import com.agarciao.backcatalog.persistence.entity.vehicle.DiagramEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagramRepository extends JpaRepository<DiagramEntity, Long> {
}
