package com.motorvehicles.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter
@Table(name="vehicles")
public class Vehicles implements  Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private VehicleType type;

    @Column(name = "body")
    private String body;

    @Column(name = "model")
    private String model;

    @Column(name = "make")
    private String make;

    @Column(name = "yearofmanufacture")
    private int yearOfManufacture;

    @OneToMany(targetEntity = VehicleLocation.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
    private List<VehicleLocation> vehicleLocations;

}
