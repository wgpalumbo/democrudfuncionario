
DROP TABLE IF EXISTS cargo;
DROP TABLE IF EXISTS funcionario;
DROP TABLE IF EXISTS funcionario_departamento;
DROP TABLE IF EXISTS departamento;

 
CREATE TABLE cargo (
  cargo_id INT AUTO_INCREMENT  PRIMARY KEY,
  cargo_name VARCHAR(50) NOT NULL ,
  cargo_chefe INT  
);

INSERT INTO cargo VALUES ( 1, 'Cargo A', 0);
INSERT INTO cargo VALUES ( 2, 'Cargo B', 0);
INSERT INTO cargo VALUES ( 3, 'Cargo C', 0);
INSERT INTO cargo VALUES ( 4, 'Cargo Chefe',1);


CREATE TABLE funcionario (
  funcionario_id INT AUTO_INCREMENT  PRIMARY KEY,
  funcionario_name VARCHAR(50) NOT NULL,
  funcionario_age INT,
  funcionario_birthday DATE,
  funcionario_document VARCHAR(50) NOT NULL,
  cargo_id INT,
  departamento_id INT
);


CREATE TABLE funcionario_departamento (
  sequencial_id INT AUTO_INCREMENT  PRIMARY KEY,
  departamento_id INT,
  funcionario_id INT  
);


CREATE TABLE departamento (
  departamento_id INT AUTO_INCREMENT  PRIMARY KEY,
  departamento_name VARCHAR(50) NOT NULL
);

INSERT INTO departamento VALUES ( 1, 'Departamento A');
INSERT INTO departamento VALUES ( 2, 'Departamento B');
INSERT INTO departamento VALUES ( 3, 'Departamento C');
INSERT INTO departamento VALUES ( 4, 'Departamento D');