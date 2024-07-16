/*show databases;

show schemas;

create database teste1;

drop database teste1;

show tables;

*/
create database first_example;
create database if not exists first_example;

/*COMANDO PARA SELECIONAR DATABASE*/
use first_example;

use world;

show databases;
show schemas;
show tables;

select * from city
where CountryCode like "BRA%"
and District like "Go%";

select * from actor
where first_name LIKE 'L%';

desc first_example;
CREATE TABLE person (
	person_id smallint unsigned,
    firtsname varchar(20),
    lastname varchar(20),
    gender enum('M','F'),
    birth_date DATE, 
    street varchar(20),
    city varchar(20),
	state varchar(20),
    country varchar(20),
    postal_code varchar(20),
    constraint person_id_fk primary key(person_id)
);

desc person;

CREATE TABLE favorite_food(
	person_id smallint unsigned,
    food varchar(20),
    constraint food_pk primary key(person_id, food),
    constraint food_person_fk foreign key(person_id) 
    references person(person_id)
);

desc favorite_food;
show databases;

select * from information_schema.table_constraints
where CONSTRAINT_SCHEMA = 'first_example';

select * from information_schema.table_constraints
where table_name = 'person';

/*Populando o banco de dados*/
insert into person values ('1', 'Lucas','Silva', 'M', '1994-08-05',
							'Rua tal', 'Cidade L', 'GO', 'Brasil', '74474377');

insert into person values ('2', 'Tampinha','Silva', 'M', '2018-08-05',
							'Rua tal', 'Cidade L', 'GO', 'Brasil', '74474377');

insert into person values ('3', 'Maria','Silva', 'M', '2018-08-05',
							'Rua tal', 'Cidade L', 'GO', 'Brasil', '74474377');

insert into person values ('4', 'Ricardo','Silva', 'M', '2018-08-05',
							'Rua tal', 'Cidade L', 'GO', 'Brasil', '74474377');

select * from person;

/*deletando pessoas de id 3 e 4*/
delete from person
where 	person_id = 3
or		person_id = 4;	

desc favorite_food;
/*populando tabela favorite food*/

insert into favorite_food(person_id, food) values (1, 'lasanha');
insert into favorite_food(person_id, food) values (2, 'carne assada');
insert into favorite_food(person_id, food) values (3, 'fetuccine');

select * from favorite_food;

delete from favorite_food
where person_id = 1
or person_id = 2
or person_id = 3;