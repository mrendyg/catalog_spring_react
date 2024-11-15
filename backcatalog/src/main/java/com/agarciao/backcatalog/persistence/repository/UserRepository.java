package com.agarciao.backcatalog.persistence.repository;

import com.agarciao.backcatalog.persistence.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntityByusername(String username);

}
