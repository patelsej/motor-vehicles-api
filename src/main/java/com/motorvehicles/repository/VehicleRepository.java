package com.motorvehicles.repository;

import com.motorvehicles.model.VehicleType;
import com.motorvehicles.model.Vehicles;
import com.motorvehicles.projection.VehicleLocationProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface VehicleRepository extends JpaRepository<Vehicles, Long> {

    public List<Vehicles> findByType(VehicleType type);


    @Query("SELECT NEW com.motorvehicles.projection.VehicleLocationProjection(" +
            "v.type, " +
            "vl.location, v.make, v.body, v.model ) " +
            "FROM Vehicles v " +
            "INNER JOIN VehicleLocation vl ON v.id=vl.vehid " +
            "WHERE v.type" +
            "=:vehicleType AND vl.location =:location " )
    List<VehicleLocationProjection> findVehicleByTypeAndLocationIgnoreCase(@Param("vehicleType") VehicleType vehicleType, @Param("location") String location);
}
