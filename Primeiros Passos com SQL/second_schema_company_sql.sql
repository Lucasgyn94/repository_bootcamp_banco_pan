create schema if not exists company;
use company;

drop table if exists employee;
create table employee(
	fName varchar(15) NOT NULL,
    mInit char,
    lName varchar(15) NOT NULL,
    ssn char(9) NOT NULL,
    bDate DATE,
    address varchar(30),
    sex char,
    salary decimal(10,2),
    super_ssn char(9),
    dNo int NOT NULL,
    constraint chk_salary_employee check (salary > 2000.0),
    constraint ssn_pk primary key(ssn)

);

alter table employee
	add constraint fk_employee foreign key (super_ssn) references employee(ssn)
    on delete set null
    on update cascade;

select * from employee;

drop table if exists departament;
create table departament(
	dName varchar(15) NOT NULL,
    dNumber int NOT NULL,
    mgr_ssn char(9),
    mgr_start_date date,
    dept_create_date date,
    constraint chk_date_dpt check (dept_create_date < mgr_start_date),
    constraint dNumber_pk primary key(dNumber),
    constraint unique_name_dept unique(dName),
    constraint mgr_ssn_fk foreign key (mgr_ssn) references employee(ssn)
);
/*Modificando uma constraint: drop e add*/

alter table departament drop constraint mgr_ssn_fk;
alter table departament
		add constraint mgr_ssn_fk foreign key(mgr_ssn) references employee(ssn)
        on update cascade;



drop table if exists dep_locations;
create table dept_locations(
	dNumber int NOT NULL,
    dLocation varchar(15) NOT NULL,
	constraint dNumber_pk primary key (dNumber, dLocation),
    constraint dNumber_dep_fk foreign key (dNumber) references departament(dNumber)
);

alter table dept_locations drop constraint dNumber_dep_fk;

alter table dept_locations
		add constraint dNumber_dep_fk foreign key (dNumber) references departament(dNumber)
		on delete cascade
        on update cascade;

drop table if exists project;
create table project(
	pName varchar(15) NOT NULL,
    pNumber int NOT NULL,
    pLocation varchar(15),
    dNum int NOT NULL,
    constraint pNumber_pk primary key (pNumber),
    constraint unique_project unique (pName),
    constraint dNum_pro_fk foreign key (dNum) references departament(dNumber)
);

drop table if exists works_on;
create table works_on(
	eSsn char(9) NOT NULL,
    pNo int NOT NULL,
    hours decimal(3,1) NOT NULL,
    constraint eSsn_pk primary key(eSsn, pNo),
    constraint eSsn_works_fk foreign key(eSsn) references employee(ssn),
    constraint pNo_works_fk foreign key(pNo) references project(pNumber)
);

drop table if exists dependent;
create table dependent(
	eSsn char(9) NOT NULL,
    dependent_name varchar(15) NOT NULL,
    sex char,
    bDate date,
    relationShip varchar(8),
    constraint eSsn_dependent_pk primary key (eSsn, dependent_name),
    constraint eSsn_dependent_fk foreign key (eSsn) references employee(ssn)
);

show tables;

desc employee;



desc departament;

desc employee;

desc works_on;

desc dependent;

show character set;

select * from information_schema.referential_constraints
where constraint_schema = 'company';

select * from information_schema.table_constraints
where constraint_schema = 'company';

desc departament;