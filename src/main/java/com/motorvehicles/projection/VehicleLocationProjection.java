package com.motorvehicles.projection;

import com.motorvehicles.model.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleLocationProjection {
    private VehicleType vehicleType;
    private String location;
    private String make;
    private String body;
    private String model;
}
