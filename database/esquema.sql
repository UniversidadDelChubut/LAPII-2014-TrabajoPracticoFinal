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

	CONSTRAINT pk_materia PRIMARY KEY (codigo),
	CONSTRAINT fk_materia FOREIGN KEY (carrera)
	REFERENCES carrera (codigo)
);
CREATE TABLE cursada (
	carrera text NOT NULL,
	materia text NOT NULL,
	anio int,
	f_inicio date NOT NULL,
	f_fin date NOT NULL
	cuatrimestre int,
	porc_asistencia real NOT NULL,
	
	CONSTRAINT pk_cursada PRIMARY KEY (carrera, materia, anio),
	CONSTRAINT fk_cursada FOREIGN KEY (carrera, codigo)
	REFERENCES materia (codigo, carrera)
	
);
CREATE TABLE comison (
	id 
	carrera text  NOT NULL,
	materia text NOT NULL,
	anio int 
	numero

	CONSTRAINT pk_comision PRIMARY KEY (id),
	CONSTRAINT fk_comison FOREIGN KEY (carrera, codigo, anio)
	REFERENCES cursada (carrera, materia, anio)
);
CREATE TABLE persona (
	
);
CREATE TABLE profesor (
);
CREATE TABLE alumno (
);
CREATE TABLE prof_comision (
);
CREATE TABLE clase (
);
CREATE TABLE asistencia (
);

ROLLBACK;
