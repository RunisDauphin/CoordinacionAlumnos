INSERT INTO Curso (idnt, nom, abreviation, annee, createAt, updateAt) values (80671, 'Desarrollo de Aplicaciones Multiplataforma 1', 'DAM 1', 1, null, null);
INSERT INTO Curso (idnt, nom, abreviation, annee, createAt, updateAt) values (80672, 'Desarrollo de Aplicaciones Multiplataforma 2', 'DAM 2', 2, null, null);

INSERT INTO Modulo (idnt, nom, abreviation, idnt_curso, groupeAlumno, createAt, updateAt)
values (0373, 'Lenguaje de marcas y Sistema de Gestión de la Información', 'LMSGI', 80671,
'2',
null, null);
INSERT INTO Modulo (idnt, nom, abreviation, idnt_curso, groupeAlumno, createAt, updateAt)
values (0483, 'Sistemas Informáticos', 'SI', 80671,
'',
null, null);
INSERT INTO Modulo (idnt, nom, abreviation, idnt_curso, groupeAlumno, createAt, updateAt)
values (0484, 'Bases de Datos', 'BD', 80671,
'',
null, null);
INSERT INTO Modulo (idnt, nom, abreviation, idnt_curso, groupeAlumno, createAt, updateAt)
values (0485, 'Programación', 'Prg', 80671,
'',
null, null);
INSERT INTO Modulo (idnt, nom, abreviation, idnt_curso, groupeAlumno, createAt, updateAt)
values (0487, 'Entornos de Desarrollo', 'ED', 80671,
'1, 2, 3',
null, null);
INSERT INTO Modulo (idnt, nom, abreviation, idnt_curso, groupeAlumno, createAt, updateAt)
values (0493, 'Formación y Orientación Laboral', 'FOL', 80671,
'',
null, null);

INSERT INTO Modulo (idnt, nom, abreviation, idnt_curso, groupeAlumno, createAt, updateAt)
values (0486, 'Acceso a Datos', 'AD', 80672,
'1, 2, 4, 5',
null, null);
INSERT INTO Modulo (idnt, nom, abreviation, idnt_curso, groupeAlumno, createAt, updateAt)
values (0488, 'Desarrollo de Interfaces', 'DI', 80672,
'1, 2, 5',
null, null);
INSERT INTO Modulo (idnt, nom, abreviation, idnt_curso, groupeAlumno, createAt, updateAt)
values (0489, 'Programación Multimedia y Dispositivos Móviles', 'PMDM', 80672,
'1, 2, 5',
null, null);
INSERT INTO Modulo (idnt, nom, abreviation, idnt_curso, groupeAlumno, createAt, updateAt)
values (0490, 'Programación de Servicios y Procesos', 'PSP', 80672,
'1, 2, 3, 4, 5',
null, null);
INSERT INTO Modulo (idnt, nom, abreviation, idnt_curso, groupeAlumno, createAt, updateAt)
values (0491, 'Sistemas de Gestión Empresarial', 'SGE', 80672,
'1, 5',
null, null);
INSERT INTO Modulo (idnt, nom, abreviation, idnt_curso, groupeAlumno, createAt, updateAt)
values (0492, 'Proyecto de DAM', 'PDAM', 80672,
'1, 2, 5',
null, null);
INSERT INTO Modulo (idnt, nom, abreviation, idnt_curso, groupeAlumno, createAt, updateAt)
values (0494, 'Empresa e Iniciativa Empresarial', 'EIE', 80672,
'1, 5',
null, null);
INSERT INTO Modulo (idnt, nom, abreviation, idnt_curso, groupeAlumno, createAt, updateAt)
values (0495, 'Formación en Centros de Trabajo', 'FCT', 80672,
'1, 2, 5',
null, null);
INSERT INTO Modulo (idnt, nom, abreviation, idnt_curso, groupeAlumno, createAt, updateAt)
values (0099, 'Inglés Técnico', 'IT', 80672,
'1, 5',
null, null);

INSERT INTO Alumno (idnt, surnom, nom, courrier, photo, groupeModulo, groupeCalification, createAt, updateAt)
values (NEXTVAL('hibernate_sequence'), 'Daniel', 'Aguilar Rodríguez', 'daniel.aguilar@alumno.iesluisvives.org', 'urali001.png',
'0487, 0486, 0488, 0489, 0490, 0491, 0492, 0494, 0495, 0099',
'1, 2, 3, 4, 5, 6, 7, 8, 9, 10',
null, null);
INSERT INTO Alumno (idnt, surnom, nom, courrier, photo, groupeModulo, groupeCalification, createAt, updateAt)
values (NEXTVAL('hibernate_sequence'), 'Rodrigo', 'Rodríguez Romero', 'rodrigo.rodriguez@alumno.iesluisvives.org', 'urali002.png',
'0373, 0487, 0486, 0488, 0489, 0490, 0492, 0495',
'11, 12, 13, 14, 15, 16, 17, 18',
null, null);
INSERT INTO Alumno (idnt, surnom, nom, courrier, photo, groupeModulo, groupeCalification, createAt, updateAt)
values (NEXTVAL('hibernate_sequence'), 'Mario', 'Valverde', 'mario.valverde@alumno.iesluisvives.org', 'urali003.png',
'0487, 0490',
'19, 20',
null, null);
INSERT INTO Alumno (idnt, surnom, nom, courrier, photo, groupeModulo, groupeCalification, createAt, updateAt)
values (NEXTVAL('hibernate_sequence'), 'Víctor', 'Domínguez', 'victor.dominguez@alumno.iesluisvives.org', 'urali004.png',
'0486, 0490',
'21, 22',
null, null);
INSERT INTO Alumno (idnt, surnom, nom, courrier, photo, groupeModulo, groupeCalification, createAt, updateAt)
values (NEXTVAL('hibernate_sequence'), 'Mario', 'González Gómez', 'mario.gonzalezg@alumno.iesluisvives.org', 'urali005.png',
'0486, 0488, 0489, 0490, 0491, 0492, 0494, 0495, 0099',
'23, 24, 25, 26, 27, 28, 29, 30, 31',
null, null);

INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 6.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 5.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 3.5)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 4.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 5.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 6.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 0.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 5.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 0.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 9.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 6.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 5.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 3.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 6.5)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 6.5)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 5.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 0.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 0.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 5.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 7.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 2.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 2.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 5.5)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 7.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 8.5)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 5.5)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 7.5)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 6.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 8.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 7.0)
INSERT INTO Calificacion (idnt, calification)
values (NEXTVAL('hibernate_sequence'), 9.0)