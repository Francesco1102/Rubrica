CREATE DATABASE IF NOT EXISTS rubrica;
USE rubrica;

create table if not exists contact (
    id bigint AUTO_INCREMENT primary key not null,
    nome character varying(255),
    cognome character varying(255),
    telefono character varying(255),
    indirizzo character varying(255),
    eta integer
);

create table if not exists user (
    id bigint AUTO_INCREMENT primary key not null,
    username character varying(255),
    password character varying(255)
);

INSERT INTO contact (nome, cognome, telefono, indirizzo, eta) VALUES
('Mario', 'Rossi', '333 1234 123', 'Via de amicis 123',23),
('Luca', 'Bianchi', '339 9876 384', 'Via delle rose 5', 66);

INSERT INTO user (username, password) VALUES
('Mario', 'prova1'),
('Luca', 'prova2'),
('admin', 'admin');