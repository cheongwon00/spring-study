package com.example.study.user.repository;

import com.example.study.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    boolean existsByName(String name);

    Optional<UserEntity> findByName(String name);
}
