package com.firecodex.hospital_management_system.bloodbank.consumption;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodConsumptionRepository extends JpaRepository<BloodConsumption, Long> {
}
