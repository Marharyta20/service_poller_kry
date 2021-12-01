package com.test.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.example.domain.ServiceEntity;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
}
