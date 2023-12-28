# TRABAJO PRÁCTICO INTEGRADOR 
## Tecnicatura Universitaria en Tecnologías de la Información
### Docentes: Dardo Kuttel / Luis Stroppi

### Creación de la base de datos

Configuración de la base de datos en el archivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/desitp
spring.datasource.username=root
spring.datasource.password=utn123
```

# Datos iniciales para cargar la BD

```
CREATE DATABASE `desitp`
```

Insert para Provincia

```
INSERT INTO Provincia (nombre) VALUES 
('Buenos Aires'),
('Córdoba'),
('Mendoza'),
('Santa Fe');
```

Insert para Ciudad

```
INSERT INTO Ciudad (nombre, provincia_id) VALUES 
('Buenos Aires', 1),
('Córdoba', 2),
('Rosario', 1),
('Mendoza', 3);
```

Insert para Persona

```
INSERT INTO Persona (dni, nombre, apellido, fecha_nacimiento, email, pasaporte, ciudad_id)
VALUES
(123456789, 'Juan', 'Pérez', '1990-01-01', 'juan.perez@email.com', 'ABC123', 1),
(987654321, 'María', 'López', '1985-05-15', 'maria.lopez@email.com', 'XYZ456', 2),
(111222333, 'Carlos', 'Gómez', '1988-08-20', 'carlos.gomez@email.com', 'DEF789', 3),
(444555666, 'Laura', 'Rodríguez', '1992-03-10', 'laura.rodriguez@email.com', 'GHI012', 1),
(777888999, 'Alejandro', 'Fernández', '1980-11-25', 'alejandro.fernandez@email.com', 'JKL345', 2);
```

Insert para Aeronave

```
INSERT INTO Aeronave (modelo, fabricante, capacidad) VALUES
('Boeing 737', 'Boeing', 150),
('Airbus A320', 'Airbus', 180),
('Embraer E190', 'Embraer', 110);
```