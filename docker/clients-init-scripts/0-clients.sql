CREATE TABLE clients
(
    id             VARCHAR(255) PRIMARY KEY,
    name           VARCHAR(255),
    first_surname  VARCHAR(255),
    second_surname VARCHAR(255)
);

INSERT INTO clients (id, name, first_surname, second_surname)
VALUES ('client-1', 'Carlos', 'García', 'López');

INSERT INTO clients (id, name, first_surname, second_surname)
VALUES ('client-2', 'María', 'Martínez', 'Sánchez');

INSERT INTO clients (id, name, first_surname, second_surname)
VALUES ('client-3', 'Juan', 'Rodríguez', 'Fernández');