package com.agarciao.backcatalog.persistence.repository;

import com.agarciao.backcatalog.persistence.entity.vehicle.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
