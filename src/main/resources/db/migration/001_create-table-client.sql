CREATE TABLE client (
	id bigint not null auto_increment,
    nome varchar(30) not null,
    email varchar(255) not null,
    cpf varchar(20) not null,
    birth DATE,
    
    primary key (id)
);
