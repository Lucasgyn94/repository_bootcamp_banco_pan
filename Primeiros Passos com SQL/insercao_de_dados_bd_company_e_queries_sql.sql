-- inserção de dados na bd_company

use company;

show tables;



insert into employee values ('John', 'B', 'Smith', 123456789, '1965-01-09', '731-Fondren-Houston-TX', 'M', 30000, 333445555, 5),
							('Franklin', 'T', 'Wong', 333445555, '1955-12-08', '638-Voss-Houston-TX', 'M', 40000, 888665555, 5),
                            ('Alicia', 'J', 'Zelaya', 999887777, '1968-01-19', '3321-Castle-Spring-TX', 'F', 25000, 987654321, 4),
                            ('Jennifer', 'S', 'Wallace', 987654321, '1941-06-20', '291-Berry-Bellaire-TX', 'F', 43000, 888665555, 4),
                            ('Ramesh', 'K', 'Narayan', 666884444, '1962-09-15', '975-Fire-Oak-Humble-TX', 'M', 38000, 333445555, 5),
                            ('Joyce', 'A', 'English', 453453453, '1972-07-31', '5631-Rice-Houston-TX', 'F', 25000, 333445555, 5),
                            ('Ahmad', 'V', 'Jabbar', 987987987, '1969-03-29', '980-Dallas-Houston-TX', 'M', 25000, 987654321, 4),
                            ('James', 'E', 'Borg', 888665555, '1937-11-10', '450-Stone-Houston-TX', 'M', 55000, NULL, 1);

select * from dependent;
insert into dependent values (333445555, 'Alice', 'F', '1986-04-05', 'Daughter'),
							 (333445555, 'Theodore', 'M', '1983-10-25', 'Son'),
                             (333445555, 'Joy', 'F', '1958-05-03', 'Spouse'),
                             (987654321, 'Abner', 'M', '1942-02-28', 'Spouse'),
                             (123456789, 'Michael', 'M', '1988-01-04', 'Son'),
                             (123456789, 'Alice', 'F', '1988-12-30', 'Daughter'),
                             (123456789, 'Elizabeth', 'F', '1967-05-05', 'Spouse');
                             
insert into departament values ('Research', 5, 333445555, '1988-05-22','1986-05-22'),
							   ('Administration', 4, 987654321, '1995-01-01','1994-01-01'),
                               ('Headquarters', 1, 888665555,'1981-06-19','1980-06-19');

insert into dept_locations values (1, 'Houston'),
								 (4, 'Stafford'),
                                 (5, 'Bellaire'),
                                 (5, 'Sugarland'),
                                 (5, 'Houston');
                                 
insert into project values ('ProductX', 1, 'Bellaire', 5),
						   ('ProductY', 2, 'Sugarland', 5),
						   ('ProductZ', 3, 'Houston', 5),
                           ('Computerization', 10, 'Stafford', 4),
                           ('Reorganization', 20, 'Houston', 1),
                           ('Newbenefits', 30, 'Stafford', 4);
                           
insert into works_on values (123456789, 1, 32.5),
							(123456789, 2, 7.5),
                            (666884444, 3, 40.0),
                            (453453453, 1, 20.0),
                            (453453453, 2, 20.0),
                            (333445555, 2, 10.0),
                            (333445555, 3, 10.0),
                            (333445555, 10, 10.0),
                            (333445555, 20, 10.0),
                            (999887777, 30, 30.0),
                            (999887777, 10, 10.0),
                            (987987987, 10, 35.0),
                            (987987987, 30, 5.0),
                            (987654321, 30, 20.0),
                            (987654321, 20, 15.0),
                            (888665555, 20, 0.0);
                            
-- consultas sql
select * from employee;
-- gerente e seu departamento
select ssn, fName, Dname from employee e, departament d where (e.ssn = d.mgr_ssn);

-- recyoerabdi dependentes dos empregados
select fName, dependent_name, relationShip from employee, dependent
where eSsn = ssn;
;

-- select dentro de employee
select bDate, address from employee
where fName = 'John' and mInit = 'B' and lName = 'Smith';

-- recuperando departamento especifico
select * from departament
where dName = 'Research';

select fName, lName, address from employee, departament
where dName = 'Research' and dNumber = dNo;

-- todas informações de project
desc works_on;
select * from project;

select * from project, works_on
where pNumber = pNo;

select pName, eSsn, hours from project, works_on
where pNumber = pNo;

select pName, eSsn, fName, hours from project, works_on, employee
where pNumber = pNo and eSsn = ssn;

-- dNumber: departament
desc departament;
desc dept_locations;

select * from departament;

select * from dept_locations;

-- retirando a ambiguidade através do alias (resolução erro 1052)
/* FORMA ERRADA
select * from departament, dept_locations
where dNumber = dNumber;
*/
-- FORMA CERTA
select dName, l.dLocation as departament_name
from departament as d, dept_locations as l
where d.dNumber = l.dNumber;

--
select * from employee;
--
-- Expressões e alias
--
-- recolhendo o valor do INSS-*
select fName, lName, salary, salary*0.011 from employee;
select fName, lName, salary, salary*0.011 as INSS from employee;
select fName, lName, salary, round(Salary*0.011,2) as INSS from employee;

-- definir um aumento de salário para os gerentes que trabalham no projeto associado ao ProdutoX
select e.fName, e.lName, 1.1*e.salary as increased_sal from employee as e,
works_on as w, project as p where e.ssn = w.eSsn and w.pNo = p.pNumber and p.pName='ProductX';

-- concatenando e fornecendo alias
select dName as Department, concat(fName, ' ', lName) as Manager from departament d, dept_locations l, employee e
where d.dNumber = l.dNumber and mgr_ssn = e.ssn;

-- recuperando dados dos empregados que trabalham para o departamento de pesquisa
select fName, lName, address from employee, departament
	where dName = 'Research' and dNumber = dNo;

-- definindo alias para legibilidade da consulta
select e.fName, e.lName, e.address from employee e, departament d
	where d.dName = 'Research' and d.dNumber = e.Dno;