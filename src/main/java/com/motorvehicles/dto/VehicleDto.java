package com.motorvehicles.dto;

import com.motorvehicles.model.VehicleLocation;
import com.motorvehicles.model.Vehicles;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * vehicles dto
 */
@NoArgsConstructor
@Data
public class VehicleDto {

    private Long id;
    private String type;
    private String make;
    private String model;
    private int yearofmanudature;

    private List<VehicleLocationDto> vehicleLocations = new ArrayList<>();

    public VehicleDto(Vehicles vehicle) {
        BeanUtils.copyProperties(vehicle, this, "vehicleLocations");

        List<VehicleLocation> vehicleLocations = vehicle.getVehicleLocations();
        if(vehicleLocations != null && vehicleLocations.size() > 0) {
            vehicleLocations.forEach(vehicleLocation -> {
                VehicleLocationDto vehicleLocationDto = new VehicleLocationDto(vehicleLocation);
                this.vehicleLocations.add(vehicleLocationDto);
            });
        }
    }
}
