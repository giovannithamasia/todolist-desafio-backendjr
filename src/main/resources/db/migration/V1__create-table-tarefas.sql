create table tarefas(
    id BIGSERIAL not null primary key,
    nome varchar(150) not null,
    descricao varchar(200) ,
    realizado Boolean not null,
    prioridade varchar(10) not null,
    constraint chk_prioridade check
       (prioridade in ('BAIXA','MEDIA','ALTA'))
);