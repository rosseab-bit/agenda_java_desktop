# agenda_java_desktop
Agenda personal en java

# Creacion de base de datos y tablas:
 * CREATE DATABASE agenda;
 * CREATE TABLE `Contactos` (
    `agendaId` int(11) NOT NULL AUTO_INCREMENT,
    `dni` int(11) NOT NULL,
    `nombre` varchar(100) DEFAULT NULL,
    `apellido` varchar(100) DEFAULT NULL,
    `direccion` varchar(100) DEFAULT NULL,
    `telefono` int(11) NOT NULL,
    `fech_nac` varchar(100) DEFAULT NULL,
    PRIMARY KEY (`agendaId`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
