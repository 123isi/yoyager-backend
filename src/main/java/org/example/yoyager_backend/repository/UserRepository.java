package org.example.yoyager_backend.repository;

import org.example.yoyager_backend.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  boolean existsByEmail(String email);
}
