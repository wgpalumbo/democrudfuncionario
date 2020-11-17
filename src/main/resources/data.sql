
DROP TABLE IF EXISTS cargo;
DROP TABLE IF EXISTS funcionario;
DROP TABLE IF EXISTS funcionario_departamento;
DROP TABLE IF EXISTS departamento;

 
CREATE TABLE cargo (
  cargo_id INT AUTO_INCREMENT  PRIMARY KEY,
  cargo_name VARCHAR(50) NOT NULL  
);


CREATE TABLE funcionario (
  funcionario_id INT AUTO_INCREMENT  PRIMARY KEY,
  funcionario_name VARCHAR(50) NOT NULL,
  funcionario_age INT,
  funcionario_birthday DATE,
  funcionario_document VARCHAR(50) NOT NULL,
  cargo_id INT
);


CREATE TABLE funcionario_departamento (
  departamento_id INT,
  funcionario_id INT
);


CREATE TABLE departamento (
  departamento_id INT AUTO_INCREMENT  PRIMARY KEY,
  departamento_name VARCHAR(50) NOT NULL
);