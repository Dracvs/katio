-- MariaDB
CREATE DATABASE Katio
COLLATE = `uca1400_spanish_ai_ci`; 
-- Accent Insensitive Case Insensitive

CREATE TABLE Users
(
    Id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name NVARCHAR(255) NOT NULL,
    Lastname NVARCHAR(255) NOT NULL,
    Email NVARCHAR(255) NOT NULL,
    Phone NVARCHAR(20) NOT NULL,
    Identification NVARCHAR(20) NOT NULL,
    Passhash NVARCHAR(255) NOT NULL,
    INDEX email_idx(Email)
);

CREATE TABLE Authors
(
    ID INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name NVARCHAR(255) NOT NULL,
    Lastname NVARCHAR(255) NOT NULL,
    Country NVARCHAR(255) NOT NULL,
    Birthdate DATE NOT NULL,
    INDEX apellido_ix(Lastname)
);

CREATE TABLE Books
(
    Id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name NVARCHAR(255) NOT NULL,
    ISBN10 NVARCHAR(255) NOT NULL,
    ISBN13 NVARCHAR(255) NOT NULL,
    Published DATE NOT NULL,
    Edition NVARCHAR(255) NOT NULL,
    Genre NVARCHAR(255) NOT NULL,
    Dewey_Index INT UNSIGNED NOT NULL,
    Author_Id INT UNSIGNED NOT NULL,
    CONSTRAINT `fk_book_author`
        FOREIGN KEY (Author_Id) REFERENCES Authors (Id)
        ON DELETE CASCADE
        ON UPDATE RESTRICT
);

INSERT INTO Authors (Name, Lastname, Country, Birthdate)
    VALUES ('Gabriel', 'García Márquez', 'Colombia', '1940-03-03');
    

INSERT INTO Authors
    SET Name = 'Jorge', Lastname = 'Isaacs', Country = 'Colombia', Birthdate = '1836-04-01' 


INSERT INTO Authors
    VALUES ('Germán', 'Castro-Caycedo', 'Colombia', '1940-03-03');


INSERT INTO Books VALUES 
    (0, 'Cien años de soledad', '8420471836', '978-8420471839', '1967-06-05', 'RAE Obra Académica', 'Realismo Mágico', '800', 1),
    (0, 'Huellas', '9584277278', '978-958427275', '2019-01-01', '1ra edicion', 'Crónica', '800', 3),
    (0, 'María', '14802722922', '978-148027292', '1867-01-01', '1ra edicion', 'Romancticismo', '800', 2)
