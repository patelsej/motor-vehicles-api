INSERT INTO vehicles
	(id, type, body, model, make, yearOfManufacture)
VALUES
	(1, 'CAR', 'SEDAN', 'CX5', 'MAZDA', 2018),
	(2,  'CAR', 'SEDAN', 'CIVIC', 'HONDA', 2018),
	(3,  'CAR', 'HETCHBACK', 'CIVIC', 'HONDA', 2018),
	(4,  'CAR', 'SEDAN', 'A4', 'AUDI', 2018);

INSERT INTO vehicle_location
    (vehid, location, latitude, longitude)
VALUES
    (1, 'Adelaide', 25.774, -80.190),
    (1, 'Parafield Gardens', 25.774, -83.190),
    (1, 'Mawson Lakes', 28.774, -80.190),
    (2, 'Mawson Lakes', 28.774, -80.190),
    (3, 'Mawson Lakes', 28.774, -80.190),
    (4, 'Parafield Gardens', 25.774, -83.190);
