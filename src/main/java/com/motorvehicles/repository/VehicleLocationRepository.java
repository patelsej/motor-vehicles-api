package com.motorvehicles.repository;

import com.motorvehicles.model.VehicleLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface VehicleLocationRepository extends JpaRepository<VehicleLocation, Long> {
    List<VehicleLocation> findByLocation(String location);
}
