package com.motorvehicles.service;

import com.motorvehicles.api.controller.response.VehicleInfoResposne;
import com.motorvehicles.dto.VehicleDto;
import com.motorvehicles.model.VehicleType;

import java.util.List;

public interface VehicleInfoService {

    VehicleInfoResposne findVehicleByTypeAndLocation(VehicleType vehicleType, String location);

    List<VehicleDto> findAllVehicles();

}
