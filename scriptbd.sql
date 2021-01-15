drop database if exists los_eren2021;
create database los_eren2021;
use los_eren2021;

create table Vehiculos(
id_vehiculo int primary key auto_increment,
tipo_vehiculo varchar(20) not null,
marca varchar(20) not null,
modelo varchar(20) not null,
año int(4) not null,
rev_tecnica tinyint not null
);


create table Clientes(
id_cliente int primary key auto_increment,
id_vehiculo int not null,
rut varchar(15) not null unique,
nombre varchar(20) not null,
apellido varchar(20) not null,
fecha_nac date not null,
direccion varchar(40),
comuna varchar(20),
constraint cliente_id_vehiculo_fk foreign key(id_vehiculo) references Vehiculos(id_vehiculo)
);

create table Servicios(
id_servicio int primary key,
tipo_servicio varchar(20) not null,
precio int(10) not null
);

create table Trabajadores(
id_trabajador int primary key auto_increment,
nombre varchar(40)
);

create table prestacion_servicios(
id_prestacion int auto_increment primary key,
id_cliente int not null,
id_trabajador int not null,
servicios varchar(20),
precio int not null,
constraint prest_serv_id_cliente_fk foreign key(id_cliente) references Clientes(id_cliente),
CONSTRAINT prest_serv_id_trabajador_fk foreign key(id_trabajador) references Trabajadores(id_trabajador)
);



insert into Vehiculos (tipo_vehiculo, marca, modelo, año, rev_tecnica)
values("Camioneta","Chevrolet","Luv",2000,1);
insert into Vehiculos (tipo_vehiculo, marca, modelo, año, rev_tecnica)
values("Auto","Fiat","Palio",2011,1);
insert into Vehiculos (tipo_vehiculo, marca, modelo, año, rev_tecnica)
values("Auto","Mazda","3",2015,0);

insert into Clientes (id_vehiculo, rut, nombre, apellido, fecha_nac, direccion, comuna) 
values(1,"15272659-4","Lucía","Barrientos","1983-10-02","Los Alamos 2278","Las Cabras");
insert into Clientes (id_vehiculo, rut, nombre, apellido, fecha_nac, direccion, comuna) 
values(2,"18556964-7","Mario","Martinez","1995-08-12","Calle uno 532","Coquimbo");
insert into Clientes (id_vehiculo, rut, nombre, apellido, fecha_nac, direccion, comuna) 
values(3,"16954871-7","Lucas","Saavedra","1987-05-30","O'Higgins 854","Concepción");

insert into Servicios (id_servicio, tipo_servicio, precio)
values(1, "Lavado Exterior",5000);
insert into Servicios (id_servicio, tipo_servicio, precio)
values(2, "Lavado Interior", 3000);
insert into Servicios (id_servicio, tipo_servicio, precio)
values(3, "Lavado de Motor",12000);

insert into Trabajadores(nombre)
values("Camilo Morales");
insert into Trabajadores(nombre)
values("Juan Perez");
insert into Trabajadores(nombre)
values("Andrés Salas");
insert into Trabajadores(nombre)
values("Mario Arredondo");
