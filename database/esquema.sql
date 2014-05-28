BEGIN; 

CREATE TABLE carrera (
	codigo text NOT NULL,
	nombre text NOT NULL,

	CONSTRAINT pk_carrera PRIMARY KEY (codigo)
);
CREATE TABLE materia (
	carrera text NOT NULL,
	codigo text NOT NULL,
	nombre text NOT NULL,
	anio int,
	cuatrimestre int,

	CONSTRAINT pk_materia PRIMARY KEY (carrera,codigo),
	CONSTRAINT fk_carrera FOREIGN KEY (carrera)
	REFERENCES carrera (codigo)
);
CREATE TABLE cursada (
	carrera text NOT NULL,
	materia text NOT NULL,
	anio int,
	f_inicio date NOT NULL,
	f_fin date NOT NULL,
	cuatrimestre int,
	porc_asistencia real NOT NULL,
	
	CONSTRAINT pk_cursada PRIMARY KEY (carrera, materia, anio),
	CONSTRAINT fk_cursada FOREIGN KEY (carrera, materia)
	REFERENCES materia (carrera,codigo)
	
);
CREATE TABLE comison (
	id serial,
	carrera text  NOT NULL,
	materia text NOT NULL,
	anio int,
	numero int,

	CONSTRAINT pk_comision PRIMARY KEY (id),
	CONSTRAINT fk_cursada FOREIGN KEY (carrera, materia, anio)
	REFERENCES cursada (carrera, materia, anio)
);
CREATE TABLE persona (
	
);
CREATE TABLE profesor (
	dni int PRIMARY KEY
);
CREATE TABLE alumno (
	legajo int PRIMARY KEY
);
CREATE TABLE prof_comision (

);
CREATE TABLE clase (
	id serial,
	obligatorio BOOLEAN,
	hora_inicio time NOT NULL,
	hora_fin time NOT NULL,
	aula text NOT NULL,
	dictada BOOLEAN,
	recuperatoria_de int,
	comision int,
	profesor int,
	hora_ingreso_profesor time,
	hora_salida_profesor time,
	
	CONSTRAINT pk_clase PRIMARY KEY(id),
	CONSTRAINT fk_comison FOREIGN KEY(comision)
	REFERENCES comison(id),
	CONSTRAINT fk_recuperatoria_de FOREIGN KEY(recuperatoria_de)
	REFERENCES clase(id)
);
CREATE TABLE asistencia (
	comision int,
	anio int,
	clase int,
	id serial,
	presente BOOLEAN,
	justificada BOOLEAN,

	CONSTRAINT pk_asistencia PRIMARY KEY(id),
	CONSTRAINT fk_comision FOREIGN KEY(comision)
	REFERENCES comison(id),
	CONSTRAINT fk_anio FOREIGN KEY(anio)
	REFERENCES alumno(legajo),
	CONSTRAINT fk_clase FOREIGN KEY(clase)
	REFERENCES clase(id)
);

ROLLBACK;
