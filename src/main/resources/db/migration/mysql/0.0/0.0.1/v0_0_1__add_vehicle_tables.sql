create table if not exists vehicles (
    id bigint(10) auto_increment not null primary key,
    type varchar(100) not null,
    body varchar(100) not null,
    make varchar(100) default null,
    model varchar(100) default null,
    yearofmanufacture int
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

create table if not exists vehicle_location (
    id bigint(10) auto_increment not null primary key,
    vehid bigint(10) not null,
    location varchar(100) not null,
    latitude double,
    longitude double,
    constraint fk_warehouse foreign key (vehid) references vehicles (id) on update cascade on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
