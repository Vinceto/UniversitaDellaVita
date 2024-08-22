--1) Listar los cursos disponibles por especialidad, filtrado por ID de especialidad
SELECT c.curso_descripcion, e.especialidad_descripcion
FROM curso c
INNER JOIN especialidad e ON (c.especialidad_id = e.especialidad_id)
WHERE c.especialidad_id = 3;

-- fase1=# SELECT c.curso_descripcion, e.especialidad_descripcion
-- FROM curso c
-- INNER JOIN especialidad e ON (c.especialidad_id = e.especialidad_id)
-- WHERE c.especialidad_id = 3;
--
-- curso_descripcion  | especialidad_descripcion
-- --------------------+--------------------------
--  Historia Universal | Historia
-- (1 fila)


-- 2) Listar el nombre de cada curso y la cantidad de alumnos inscritos
SELECT c.curso_descripcion, COUNT(ac.alumno_id) AS cantidad_alumnos
FROM curso c
JOIN alumno_curso ac ON c.curso_id = ac.curso_id
GROUP BY c.curso_id, c.curso_descripcion;

-- fase1=# SELECT c.curso_descripcion, COUNT(ac.alumno_id) AS cantidad_alumnos
-- FROM curso c
-- JOIN alumno_curso ac ON c.curso_id = ac.curso_id
-- GROUP BY c.curso_id, c.curso_descripcion;
--
-- curso_descripcion  | cantidad_alumnos
-- --------------------+------------------
--  Inglés Básico      |                2
--  Física             |                2
--  Historia Universal |                2
--  Álgebra            |                2
-- (4 filas)


-- 3)Listar todos los alumnos indicando nombre, apellido, email, cantidad de ramos tomados para una especialidad (usando el ID de especialidad 3 como ejemplo):
SELECT a.alumno_nombre, a.alumno_apellido, a.alumno_email, COUNT(ac.curso_id) AS cantidad_ramos
FROM alumno a
INNER JOIN alumno_curso ac ON a.alumno_id = ac.alumno_id
INNER JOIN curso c ON ac.curso_id = c.curso_id
WHERE c.especialidad_id = 3
GROUP BY a.alumno_id, a.alumno_nombre, a.alumno_apellido, a.alumno_email;

-- fase1=# SELECT a.alumno_nombre, a.alumno_apellido, a.alumno_email, COUNT(ac.curso_id) AS cantidad_ramos
-- FROM alumno a
-- INNER JOIN alumno_curso ac ON a.alumno_id = ac.alumno_id
-- INNER JOIN curso c ON ac.curso_id = c.curso_id
-- WHERE c.especialidad_id = 3
-- GROUP BY a.alumno_id, a.alumno_nombre, a.alumno_apellido, a.alumno_email;
-- alumno_nombre | alumno_apellido |         alumno_email         | cantidad_ramos
-- ---------------+-----------------+------------------------------+----------------
--  Luis          | Gomez           | luis.gomez@example.com       |              1
--  Carlos        | Fernandez       | carlos.fernandez@example.com |              1
-- (2 filas)


-- 4)Listar la cantidad de inasistencias de todos los cursos para una fecha específica (ejemplo: 2024-05-01):
SELECT c.curso_descripcion, COUNT(*) AS cantidad_inasistencias
FROM asistencia_alumno_curso aac
INNER JOIN alumno_curso ac ON aac.alumno_curso_id = ac.alumno_curso_id
INNER JOIN curso c ON ac.curso_id = c.curso_id
WHERE aac.fecha = '2024-05-01' AND aac.asiste = FALSE
GROUP BY c.curso_id, c.curso_descripcion;

-- fase1=# SELECT c.curso_descripcion, COUNT(*) AS cantidad_inasistencias
-- FROM asistencia_alumno_curso aac
-- INNER JOIN alumno_curso ac ON aac.alumno_curso_id = ac.alumno_curso_id
-- INNER JOIN curso c ON ac.curso_id = c.curso_id
-- WHERE aac.fecha = '2024-05-01' AND aac.asiste = FALSE
-- GROUP BY c.curso_id, c.curso_descripcion;
-- curso_descripcion | cantidad_inasistencias
-- -------------------+------------------------
--  Álgebra           |                      1
--  Física            |                      1
-- (2 filas)

-- 5) Agrupar la cantidad de asistencias que se han realizado para un alumno en un curso determinado, mostrando cantidad, el nombre del alumno y el curso, en orden descendiente por la cantidad de asistencias:
SELECT a.alumno_nombre, a.alumno_apellido, c.curso_descripcion, COUNT(*) AS cantidad_asistencias
FROM asistencia_alumno_curso aac
INNER JOIN alumno_curso ac ON aac.alumno_curso_id = ac.alumno_curso_id
INNER JOIN alumno a ON ac.alumno_id = a.alumno_id
INNER JOIN curso c ON ac.curso_id = c.curso_id
WHERE aac.asiste = 1
GROUP BY a.alumno_id, a.alumno_nombre, a.alumno_apellido, c.curso_id, c.curso_descripcion
ORDER BY cantidad_asistencias DESC;

-- fase1=# SELECT a.alumno_nombre, a.alumno_apellido, c.curso_descripcion, COUNT(*) AS cantidad_asistencias
-- FROM asistencia_alumno_curso aac
-- INNER JOIN alumno_curso ac ON aac.alumno_curso_id = ac.alumno_curso_id
-- INNER JOIN alumno a ON ac.alumno_id = a.alumno_id
-- INNER JOIN curso c ON ac.curso_id = c.curso_id
-- WHERE aac.asiste = TRUE
-- GROUP BY a.alumno_id, a.alumno_nombre, a.alumno_apellido, c.curso_id, c.curso_descripcion
-- ORDER BY cantidad_asistencias DESC;
--
-- alumno_nombre | alumno_apellido | curso_descripcion | cantidad_asistencias
-- ---------------+-----------------+-------------------+----------------------
--  Luis          | Gomez           | Álgebra           |                    1
--  Carlos        | Fernandez       | Física            |                    1
-- (2 filas)

