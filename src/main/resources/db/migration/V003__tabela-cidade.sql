create table algafood.cidade(
	id bigint not null auto_increment,
    nome varchar(80) not null,
    estado_id bigint not null,
	
    primary key (id),
    constraint fk_cidade_estado foreign key (estado_id)
    references algafood.estado(id)
)engine=InnoDB default charset=utf8;