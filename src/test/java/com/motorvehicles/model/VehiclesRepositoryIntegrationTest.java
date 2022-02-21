package com.motorvehicles.model;

import com.motorvehicles.repository.VehicleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VehiclesRepositoryIntegrationTest {

    @Autowired
    private VehicleRepository subject;

    @AfterEach
    public void tearDown() throws Exception {
        subject.deleteAll();
    }

    @Test
    public void shouldSaveAndFetchVehicle() throws Exception {
        var car1 = new Vehicles();
        car1.setType(VehicleType.CAR);
        car1.setBody("testbody");
        car1.setMake("testmake");
        car1.setModel("testmodel");
        car1.setYearOfManufacture(2000);
        subject.save(car1);

        var vehicles = subject.findByType(VehicleType.CAR);

        assertFalse(vehicles.isEmpty());
    }
}