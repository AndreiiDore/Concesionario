create database concesionario;
use concesionario;
create table usuario(
	id int(10) auto_increment primary key,
    nombre varchar(50) not null,
    contraseña varchar(50) not null,
    pregunta varchar(100),
    respuesta varchar(100)
);
create table coches(
id int(10),
marca varchar(50),
matricula varchar(50),
modelo varchar(50),
color varchar(20),
duenio int(10),
precio int(50),
foreign key (duenio) references usuario(id)
);
delimiter |
create procedure verCoches(
id int(10),
marca varchar(50),
matricula varchar(50),
modelo varchar(50),
color varchar(20),
duenio int(10),
precio int(50)
)
begin select * from coche;
end |

