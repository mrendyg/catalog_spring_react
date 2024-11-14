package com.agarciao.backcatalog.persistence.repository;

import com.agarciao.backcatalog.persistence.entity.vehicle.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
}
