package com.motorvehicles.service.impl;

import com.motorvehicles.api.controller.response.VehicleInfoResposne;
import com.motorvehicles.dto.VehicleDto;
import com.motorvehicles.model.VehicleType;
import com.motorvehicles.projection.VehicleLocationProjection;
import com.motorvehicles.repository.VehicleRepository;
import com.motorvehicles.service.VehicleInfoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
public class VehicleInfoServiceImpl implements VehicleInfoService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleInfoServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    /**
     * Returns a stock snapshot of a product, until the given date.
     * Accurate retrieval, using hours, minutes and seconds as parameter.
     */
    @Override
    public VehicleInfoResposne findVehicleByTypeAndLocation(VehicleType vehicleType, String location) {
        log.info("Find vehicle by vehicle type and location");
        List<VehicleLocationProjection> vehicleLocationProjections =  this.vehicleRepository.findVehicleByTypeAndLocationIgnoreCase(vehicleType, location);
        return VehicleInfoResposne.builder()
                .vehicleLocationProjections(vehicleLocationProjections)
                .numberOfVehiclesPerLocation( vehicleLocationProjections != null ? vehicleLocationProjections.size() : 0 ).build();
    }

    @Override
    public List<VehicleDto> findAllVehicles() {
        log.info("Find all vehicles");
        return this.vehicleRepository.findAll()
                .stream()
                .map(VehicleDto::new)
                .collect(Collectors.toList());
    }

}
