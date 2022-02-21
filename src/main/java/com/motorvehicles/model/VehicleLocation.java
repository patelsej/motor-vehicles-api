package com.motorvehicles.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter
@Table(name = "vehicle_location")
public class VehicleLocation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "vehid")
    private long vehid;

    @Column(name = "location")
    private String location;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @ManyToOne
    @JoinColumn(name = "vehid", insertable = false, updatable = false)
    private Vehicles vehicle;
}
