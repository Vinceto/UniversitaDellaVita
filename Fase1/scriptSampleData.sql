-- Insert data into especialidad
INSERT INTO especialidad (especialidad_descripcion)
VALUES
    ('Matemáticas'),
    ('Ciencias'),
    ('Historia'),
    ('Idiomas');

-- postgres=# SELECT * FROM especialidad;
-- especialidad_id | especialidad_descripcion
-- -----------------+--------------------------
--                1 | Matemáticas
--                2 | Ciencias
--                3 | Historia
--                4 | Idiomas
-- (4 filas)


-- Insert data into profesor
INSERT INTO profesor (profesor_nombre, profesor_email)
VALUES
    ('Juan Perez', 'juan.perez@example.com'),
    ('Maria Lopez', 'maria.lopez@example.com'),
    ('Carlos Sanchez', 'carlos.sanchez@example.com'),
    ('Ana Martinez', 'ana.martinez@example.com');

-- postgres=# SELECT * FROM profesor;
-- profesor_id | profesor_nombre |       profesor_email
-- -------------+-----------------+----------------------------
--            1 | Juan Perez      | juan.perez@example.com
--            2 | Maria Lopez     | maria.lopez@example.com
--            3 | Carlos Sanchez  | carlos.sanchez@example.com
--            4 | Ana Martinez    | ana.martinez@example.com
-- (4 filas)

-- Insert data into curso
INSERT INTO curso (curso_descripcion, especialidad_id, profesor_id)
VALUES
    ('Álgebra', 1, 1),
    ('Física', 2, 2),
    ('Historia Universal', 3, 3),
    ('Inglés Básico', 4, 4);

-- postgres=# SELECT * FROM curso;
-- curso_id | curso_descripcion  | especialidad_id | profesor_id
-- ----------+--------------------+-----------------+-------------
--         1 | Álgebra            |               1 |           1
--         2 | Física             |               2 |           2
--         3 | Historia Universal |               3 |           3
--         4 | Inglés Básico      |               4 |           4
-- (4 filas)

-- Insert data into alumno
INSERT INTO alumno (alumno_nombre, alumno_apellido, alumno_email)
VALUES
    ('Luis', 'Gomez', 'luis.gomez@example.com'),
    ('Marta', 'Diaz', 'marta.diaz@example.com'),
    ('Carlos', 'Fernandez', 'carlos.fernandez@example.com'),
    ('Elena', 'Ruiz', 'elena.ruiz@example.com');

-- postgres=# SELECT * FROM alumno;
-- alumno_id | alumno_nombre | alumno_apellido |         alumno_email
-- -----------+---------------+-----------------+------------------------------
--          1 | Luis          | Gomez           | luis.gomez@example.com
--          2 | Marta         | Diaz            | marta.diaz@example.com
--          3 | Carlos        | Fernandez       | carlos.fernandez@example.com
--          4 | Elena         | Ruiz            | elena.ruiz@example.com
-- (4 filas)

-- Insert data into alumno_curso
INSERT INTO alumno_curso (curso_id, alumno_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (2, 4),
    (3, 1),
    (3, 3),
    (4, 2),
    (4, 4);

-- postgres=# SELECT * FROM alumno_curso;
-- alumno_curso_id | curso_id | alumno_id
-- -----------------+----------+-----------
--                1 |        1 |         1
--                2 |        1 |         2
--                3 |        2 |         3
--                4 |        2 |         4
--                5 |        3 |         1
--                6 |        3 |         3
--                7 |        4 |         2
--                8 |        4 |         4
-- (8 filas)


-- Insert data into evaluacion
INSERT INTO evaluacion (evaluacion_descripcion)
VALUES
    ('Primer Examen'),
    ('Segundo Examen'),
    ('Examen Final');

-- postgres=# SELECT * FROM evaluacion;
-- evaluacion_id | evaluacion_descripcion
-- ---------------+------------------------
--              1 | Primer Examen
--              2 | Segundo Examen
--              3 | Examen Final
-- (3 filas)

-- Insert data into evaluacion_alumno_curso
INSERT INTO evaluacion_alumno_curso (alumno_curso_id, evaluacion_id, nota)
VALUES
    (1, 1, 5.0),
    (1, 2, 6.0),
    (1, 3, 7.0),
    (2, 1, 4.0),
    (2, 2, 5.5),
    (2, 3, 6.0),
    (3, 1, 6.0),
    (3, 2, 7.0),
    (3, 3, 8.0);

-- postgres=# SELECT * FROM evaluacion_alumno_curso;
-- evaluacion_alumno_curso_id | alumno_curso_id | evaluacion_id | nota
-- ----------------------------+-----------------+---------------+------
--                           1 |               1 |             1 |    5
--                           2 |               1 |             2 |    6
--                           3 |               1 |             3 |    7
--                           4 |               2 |             1 |    4
--                           5 |               2 |             2 |  5.5
--                           6 |               2 |             3 |    6
--                           7 |               3 |             1 |    6
--                           8 |               3 |             2 |    7
--                           9 |               3 |             3 |    8
-- (9 filas)

-- Insert data into asistencia_alumno_curso
INSERT INTO asistencia_alumno_curso (alumno_curso_id, asiste, fecha)
VALUES
    (1, TRUE, '2024-05-01'),
    (2, FALSE, '2024-05-01'),
    (3, TRUE, '2024-05-01'),
    (4, FALSE, '2024-05-01');

-- postgres=# SELECT * FROM asistencia_alumno_curso;
-- asistencia_alumno_curso_id | alumno_curso_id | asiste |   fecha
-- ----------------------------+-----------------+--------+------------
--                           1 |               1 | t      | 2024-05-01
--                           2 |               2 | f      | 2024-05-01
--                           3 |               3 | t      | 2024-05-01
--                           4 |               4 | f      | 2024-05-01
-- (4 filas)
