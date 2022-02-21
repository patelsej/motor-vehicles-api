package com.motorvehicles.api.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.motorvehicles.projection.VehicleLocationProjection;
import lombok.*;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
/**
 * API Resposne for vehicle info service call. *
 */
public class VehicleInfoResposne {
    private List<VehicleLocationProjection> vehicleLocationProjections;
    private int numberIfVehiclesPerLocation;
}
