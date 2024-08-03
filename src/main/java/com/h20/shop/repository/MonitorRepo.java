package com.h20.shop.repository;

import com.h20.shop.entity.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorRepo extends JpaRepository<Monitor, Long> {
}
