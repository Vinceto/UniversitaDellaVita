-- Table: especialidad
CREATE TABLE especialidad (
    especialidad_id SERIAL PRIMARY KEY,
    especialidad_descripcion VARCHAR(50)
);

-- Table: profesor
CREATE TABLE profesor (
    profesor_id SERIAL PRIMARY KEY,
    profesor_nombre VARCHAR(50),
    profesor_email VARCHAR(50)
);

-- Table: curso
CREATE TABLE curso (
    curso_id SERIAL PRIMARY KEY,
    curso_descripcion VARCHAR(50),
    especialidad_id INT,
    profesor_id INT,
    FOREIGN KEY (especialidad_id) REFERENCES especialidad(especialidad_id),
    FOREIGN KEY (profesor_id) REFERENCES profesor(profesor_id)
);

-- Table: alumno
CREATE TABLE alumno (
    alumno_id SERIAL PRIMARY KEY,
    alumno_nombre VARCHAR(50),
    alumno_apellido VARCHAR(50),
    alumno_email VARCHAR(50)
);

-- Table: alumno_curso
CREATE TABLE alumno_curso (
    alumno_curso_id SERIAL PRIMARY KEY,
    curso_id INT,
    alumno_id INT,
    FOREIGN KEY (curso_id) REFERENCES curso(curso_id),
    FOREIGN KEY (alumno_id) REFERENCES alumno(alumno_id)
);

-- Table: evaluacion
CREATE TABLE evaluacion (
    evaluacion_id SERIAL PRIMARY KEY,
    evaluacion_descripcion VARCHAR(50)
);

-- Table: evaluacion_alumno_curso
CREATE TABLE evaluacion_alumno_curso (
    evaluacion_alumno_curso_id SERIAL PRIMARY KEY,
    alumno_curso_id INT,
    evaluacion_id INT,
    nota DOUBLE PRECISION,
    FOREIGN KEY (alumno_curso_id) REFERENCES alumno_curso(alumno_curso_id),
    FOREIGN KEY (evaluacion_id) REFERENCES evaluacion(evaluacion_id)
);

-- Table: asistencia_alumno_curso
CREATE TABLE asistencia_alumno_curso (
    asistencia_alumno_curso_id SERIAL PRIMARY KEY,
    alumno_curso_id INT,
    asiste BOOLEAN,
    fecha DATE,
    FOREIGN KEY (alumno_curso_id) REFERENCES alumno_curso(alumno_curso_id)
);

-- Lista de tablas creadas para ejercicios de fase 1
-- fase1=# \dt
-- Listado de relaciones
--  Esquema |         Nombre          | Tipo  |  Due±o
-- ---------+-------------------------+-------+----------
--  public  | alumno                  | tabla | postgres
--  public  | alumno_curso            | tabla | postgres
--  public  | asistencia_alumno_curso | tabla | postgres
--  public  | curso                   | tabla | postgres
--  public  | especialidad            | tabla | postgres
--  public  | evaluacion              | tabla | postgres
--  public  | evaluacion_alumno_curso | tabla | postgres
--  public  | profesor                | tabla | postgres
-- (8 filas)
