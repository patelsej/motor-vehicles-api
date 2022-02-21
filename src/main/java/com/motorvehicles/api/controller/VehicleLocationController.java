package com.motorvehicles.api.controller;


import com.motorvehicles.api.controller.response.VehicleInfoResposne;
import com.motorvehicles.model.VehicleType;
import com.motorvehicles.service.VehicleInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for vehicle info API endpoint
 */
@RestController
@RequestMapping("/vehicles")
@Api(value = "Vehicle Location")
public class VehicleLocationController {

    private final VehicleInfoService vehicleInfoService;

    /**
     * Creates VehicleLocationController
     * @param vehicleInfoService
     */
    @Autowired
    public VehicleLocationController(VehicleInfoService vehicleInfoService) {
        this.vehicleInfoService = vehicleInfoService;
    }

    @ApiOperation(value = "Returns list of vehicles")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 100, message = "100 is the message"),
                    @ApiResponse(code = 200, message = "Successful")
            }
    )

    /**
     * Get endpoint to fetch vehicles by vehicle type and location.
     * @param vehicleType
     * @param location
     */
    @GetMapping(value = "/{vehicleType}/{location}", produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleInfoResposne findVehiclesLocationByLocation(@PathVariable("vehicleType") VehicleType vehicleType,
                                                              @PathVariable("location") String location) {
        return this.vehicleInfoService.findVehicleByTypeAndLocation(vehicleType, location);
    }

}
