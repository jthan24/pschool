--Creacion del usuario
CREATE USER 'testuser'@'localhost' IDENTIFIED BY 'testuser';

--Creacion de la bas de datos
create database test_db;

--Asignacion de permisos del usuario en la base de datos
GRANT ALL ON test_db.* TO 'testuser'@'localhost';
