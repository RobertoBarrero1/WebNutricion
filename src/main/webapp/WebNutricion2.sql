create database WebNutricion2;

use WebNutricion2;

create table productos(
id_producto int auto_increment primary key not null,
nombre varchar(100) not null,
peso varchar(100) not null,
precio varchar(100) not null,
descripcion varchar(100) not null,
imagen_url varchar(250) default null
);

create table usuario(
id_usuario int primary key auto_increment not null,
nombre varchar(100) not null,
apellidos varchar(100) not null,
email varchar(150) not null,
contraseña varchar(250) not null,
direccion varchar(250) not null,
rol int NOT NULL DEFAULT 2 COMMENT '9: Admin, 2: Usuario'
);

alter table usuario add fecha_nacimiento date