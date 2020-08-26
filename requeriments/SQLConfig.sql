USE HLocadora;

DROP TABLE alugueis; 

CREATE TABLE alugueis (
    id_aluguel INT (11) NOT NULL AUTO_INCREMENT COMMENT 'ID Titulo',
	nome_filme VARCHAR (255) NOT NULL COMMENT 'Nome do filme',
    cpf_usuario VARCHAR (255) NOT NULL COMMENT 'CPF usuario',
    data_recebimento  VARCHAR (255) NOT NULL COMMENT 'Data de Recebimento',
    data_entrega  VARCHAR (255) NOT NULL COMMENT 'Data Entrega',
	status_entrega  VARCHAR (255) NOT NULL COMMENT 'Status da entrega',
    PRIMARY KEY (id_aluguel)
  ) CHARSET = utf8; 
  
  insert into alugueis (nome_filme,cpf_usuario,data_recebimento,data_entrega,status_entrega) values ("Noiva Cadaver","123","06-03-2020","07-03-2020","aberto");
  
/*
DROP TABLE filmes;

CREATE TABLE filmes (
    id_filme INT (11) NOT NULL AUTO_INCREMENT COMMENT 'ID Titulo',
	nome VARCHAR (255) NOT NULL COMMENT 'Nome',
    sinopse VARCHAR (255) NOT NULL COMMENT 'Sinopse',
    estoque INT(10) NOT NULL COMMENT 'Estoque',
    PRIMARY KEY (id_filme)
  ) CHARSET = utf8; 
  
INSERT INTO filmes (nome,sinopse,estoque) values ("Noiva cadaver","Conta de uma noiva cadaver",10);
INSERT INTO filmes (nome,sinopse,estoque) values ("O turista","Conta a historia de um turista",10);
INSERT INTO filmes (nome,sinopse,estoque) values ("O segredo dos animais","Conta o segredo dos animais",10);
    
    
    
CREATE TABLE clientes (
    id_cliente INT (11) NOT NULL AUTO_INCREMENT COMMENT 'ID Titulo',
	nome VARCHAR (255) NOT NULL COMMENT 'Nome',
    idade VARCHAR (255) NOT NULL COMMENT 'Idade',
    endereco VARCHAR (255) NOT NULL COMMENT 'Endereco',
    cpf VARCHAR (255) NOT NULL COMMENT 'Avaliacao',
    PRIMARY KEY (id_cliente)
  ) CHARSET = utf8; 
insert into clientes (nome,idade,endereco,cpf) values ("Gustavo","19","R. Jupia 184","14202872657");
select * from clientes;
 DROP DATABASE HLocadora;
CREATE DATABASE HLocadora;
USE  HLocadora;

CREATE TABLE clientes (
    id_cliente INT (11) NOT NULL AUTO_INCREMENT COMMENT 'ID Titulo',
	nome VARCHAR (255) NOT NULL COMMENT 'Nome',
    idade VARCHAR (255) NOT NULL COMMENT 'Idade',
    endereco VARCHAR (255) NOT NULL COMMENT 'Endereco',
    cpf VARCHAR (255) NOT NULL COMMENT 'Avaliacao',
    PRIMARY KEY (id_cliente)
  ) CHARSET = utf8; 
insert into clientes (nome,idade,endereco,cpf) values ("Gustavo","19","R. Jupia 184","14202872657");







 CREATE TABLE usuarios (
    id_usuario INT (11) NOT NULL AUTO_INCREMENT COMMENT 'ID Titulo',
    usuario VARCHAR (255) NOT NULL COMMENT 'Nome',
    senha VARCHAR (255) NOT NULL COMMENT 'Genero',
    nivel_permissao VARCHAR (255) NOT NULL COMMENT 'Sinopse',
     PRIMARY KEY (id_usuario)
) CHARSET = utf8;

TRUNCATE TABLE usuarios; 
INSERT INTO usuarios (usuario,senha,nivel_permissao) values ("root","123","1");

 
  
    CREATE TABLE aluguel (
    id_aluguel INT (11) NOT NULL AUTO_INCREMENT COMMENT 'ID Titulo',
	cpf_cliente VARCHAR (255) NOT NULL COMMENT 'CPF Cliente',
    id_titulo VARCHAR (255) NOT NULL COMMENT 'Titulo',
    data_recebimento VARCHAR (255) NOT NULL COMMENT 'Data Recebimento',
    data_entrega VARCHAR (255) NOT NULL COMMENT 'Data entrega',
    PRIMARY KEY (id_aluguel)
  ) CHARSET = utf8; 
  
  insert into aluguel (cpf_cliente,id_titulo,data_recebimento,data_entrega) values ("14202872657",'1',"25/08/2020","30/08/2020");