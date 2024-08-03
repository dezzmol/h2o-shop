package com.h20.shop.repository;

import com.h20.shop.entity.HardDrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardDriveRepo extends JpaRepository<HardDrive, Long> {
}
