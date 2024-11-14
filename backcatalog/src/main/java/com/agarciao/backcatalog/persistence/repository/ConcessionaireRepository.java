package com.agarciao.backcatalog.persistence.repository;

import com.agarciao.backcatalog.persistence.entity.user.ConcessionaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcessionaireRepository extends JpaRepository<ConcessionaireEntity, Long> {
}
