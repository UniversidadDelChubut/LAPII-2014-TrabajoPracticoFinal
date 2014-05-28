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


	CONSTRAINT pk_materia PRIMARY KEY (carrera, codigo),
	CONSTRAINT fk_materia FOREIGN KEY (carrera)

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

	REFERENCES materia (carrera, codigo)
	
);
CREATE TABLE comision (
	id serial,
	carrera text  NOT NULL,
	materia text NOT NULL,
	anio int, 
	numero int,

	CONSTRAINT pk_comision PRIMARY KEY (id),
	CONSTRAINT fk_comison FOREIGN KEY (carrera, materia, anio)
	REFERENCES cursada (carrera, materia, anio),
	CONSTRAINT unq_comision UNIQUE (carrera, materia, anio, numero)

);
CREATE TABLE persona (
	nombre text NOT NULL,
	apellido text NOT NULL,
	f_nacimiento date,
	direccion text NOT NULL,
	documento int not null,
	CONSTRAINT pk_persona
		PRIMARY KEY (documento),
	CONSTRAINT chk_doc_valido
		CHECK (documento between 10000000 and 99999999 )
);
CREATE TABLE profesor (

	documento int NOT NULL,
	CONSTRAINT pk_profesor
		PRIMARY KEY (documento),
	CONSTRAINT fk_documento
		FOREIGN KEY (documento)
		REFERENCES persona (documento)


);
CREATE TABLE alumno (
	documento  int NOT NULL,
	legajo text,
	CONSTRAINT pk_alumno
		PRIMARY KEY (legajo),
	CONSTRAINT chk_legajo_valido
		CHECK (legajo ~ E'[A-Z]{3}\\d{3}')
	CONSTRAINT fk_documento
		FOREIGN KEY (documento)
		REFERENCES persona (documento)	

);
CREATE TABLE prof_comision (
	profesor int NOt NULL,
	comision serial NOT NULL,
	f_desde date NOT NULL,
	f_hasta date NOT NULL,

	CONSTRAINT pk_prof_comision
		PRIMARY KEY (profesor, comision, f_desde),
	CONSTRAINT fk_profesor
		FOREIGN KEY (profesor)
		REFERENCES profesor (documento),
	CONSTRAINT fk_comision
		FOREIGN KEY (comision)
		REFERENCES comision (id)	

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
	CONSTRAINT fk_comision FOREIGN KEY(comision)
	REFERENCES comision(id),
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
	REFERENCES comision(id),
	CONSTRAINT fk_anio FOREIGN KEY(anio)
	REFERENCES alumno(legajo),
	CONSTRAINT fk_clase FOREIGN KEY(clase)
	REFERENCES clase(id)
);

ROLLBACK;
