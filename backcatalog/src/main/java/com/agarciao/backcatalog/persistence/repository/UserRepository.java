package com.agarciao.backcatalog.persistence.repository;

import com.agarciao.backcatalog.persistence.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
