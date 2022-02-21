package com.motorvehicles.api.controller;

import com.motorvehicles.api.controller.response.VehicleInfoResposne;
import com.motorvehicles.model.VehicleType;
import com.motorvehicles.service.VehicleInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static  org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class VehicleLocationControllerTest {

    private VehicleInfoService vehicleInfoService;
    private VehicleLocationController vehicleLocationController;
    private VehicleInfoResposne vehicleInfoResposne;

    @BeforeEach
    void setup() {
        vehicleInfoService = mock(VehicleInfoService.class);
        vehicleLocationController = new VehicleLocationController(vehicleInfoService);
        vehicleInfoResposne = mock(VehicleInfoResposne.class);
    }

    @Test
    void findByTypeAndLocation() {
        when(vehicleInfoService.findVehicleByTypeAndLocation(VehicleType.CAR, "LOCATION")).thenReturn(vehicleInfoResposne);
        assertEquals(vehicleInfoResposne, vehicleLocationController.findVehiclesLocationByLocation(VehicleType.CAR, "LOCATION"));
    }
}
