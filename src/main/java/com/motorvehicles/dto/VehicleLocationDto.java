package com.motorvehicles.dto;

import com.motorvehicles.model.VehicleLocation;
import com.motorvehicles.model.Vehicles;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * vehicle_location dto
 */
@NoArgsConstructor
@Data
public class VehicleLocationDto {

    private Long id;
    private String code;
    private Long vehId;

    public VehicleLocationDto(VehicleLocation vehicleLocation) {
        BeanUtils.copyProperties(vehicleLocation, this, "vehId");

        Vehicles vehicle = vehicleLocation.getVehicle();
        if (vehicle != null) {
            this.vehId = vehicle.getId();
        }
    }
}

