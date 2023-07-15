CREATE DATABASE empresa_data;

CREATE TABLE planta (
	id_planta NUMERIC (4) PRIMARY KEY,
	superficie NUMERIC (4),
	proceso VARCHAR (50),
	direccion VARCHAR (100)
);

CREATE TABLE operador (
	id_operador NUMERIC (4) PRIMARY KEY,
	dni CHAR (8),
	nombre VARCHAR (50),
	telefono NUMERIC (9)
);

CREATE TABLE maquinaria (
	id_maquinaria NUMERIC (4) PRIMARY KEY,
	codigo CHAR (8),
	marca VARCHAR (50),
	modelo VARCHAR (50),
	descripcion VARCHAR (100),
	id_planta NUMERIC (4),
	FOREIGN KEY (id_planta) REFERENCES planta (id_planta)
);

CREATE TABLE turnos_operacion (
	id_turno_operacion NUMERIC (4) PRIMARY KEY,
	turno CHAR (1),
	fecha_inicio VARCHAR (10),
	fecha_fin VARCHAR (10),
	estado CHAR (1),
	id_operador NUMERIC (4),
	id_maquinaria NUMERIC (4),
	FOREIGN KEY (id_operador) REFERENCES operador (id_operador),
	FOREIGN KEY (id_maquinaria) REFERENCES maquinaria (id_maquinaria)
);

INSERT INTO planta VALUES (1,3000,'Fabricacion','Calle La Victoria 2025');
INSERT INTO planta VALUES (2,1500,'Envase','Calle General Sifuentes 2040');

INSERT INTO maquinaria VALUES (1,'MAQ10001','Sommetrade','Llenadoras','Liquidos y semiliquidos',1);
INSERT INTO maquinaria VALUES (2,'MAQ10002','Renault','SOMME MARINA','CERRADORAS NUEVA FORMA',1);
INSERT INTO maquinaria VALUES (3,'MAQ10002','Ezquerra','SOMMEQ6','CERRADORAS CILINDRICO',2);
INSERT INTO maquinaria VALUES (4,'MAQ10002','Ezquerra','e-320','CERRADORAS CILINDRICO BAJA',1);
INSERT INTO maquinaria VALUES (5,'MAQ10002','Sommetrade','GRP-330','Grupo llenado',2);

INSERT INTO operador VALUES (1,'22222222','Juan Chumpitaz',99999999);
INSERT INTO operador VALUES (2,'33333333','Martin Fernandez',91111111);
INSERT INTO operador VALUES (3,'44444444','Julio Pozu',92222222);


INSERT INTO turnos_operacion VALUES (1,'M','01-06-2023','30-07-2023','A',1,1);
INSERT INTO turnos_operacion VALUES (2,'T','01-06-2023','30-06-2023','I',1,2);
INSERT INTO turnos_operacion VALUES (3,'N','01-07-2023','30-07-2023','A',2,3);
INSERT INTO turnos_operacion VALUES (4,'T','30-06-2023','30-07-2023','A',1,4);
INSERT INTO turnos_operacion VALUES (5,'T','01-06-2023','30-07-2023','A',2,1);
INSERT INTO turnos_operacion VALUES (6,'M','01-06-2023','30-07-2023','I',2,5);


SELECT o.dni, o.nombre, t.turno, t.fecha_inicio, t.fecha_fin, t.estado, m.codigo, m.marca, m.modelo, m.descripcion, p.superficie, p.proceso FROM operador o INNER JOIN turnos_operacion t ON (o.id_operador = t.id_operador) INNER JOIN maquinaria m ON (m.id_maquinaria = t.id_maquinaria) INNER JOIN planta p ON (m.id_planta = p.id_planta) WHERE t.estado = 'A' OR t.estado IS NULL ;

INSERT INTO maquinaria (id_maquinaria, codigo, marca, modelo, descripcion, id_planta) VALUES (?,?,?,?,?,?);


