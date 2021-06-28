drop table employee if exists;

create table employee (
	employee_code varchar(100) primary key,
	last_name varchar(100) not null,
	first_name varchar(100) not null,
	last_kana_name varchar(100) not null,
	first_kana_name varchar(100) not null,
	gender int not null,
	birth_day date not null,
	section_code varchar(100),
	hire_date date not null,
	password varchar(100) not null
);

insert into employee values('E000', 'マグロ', '軍艦', 'まぐろ', 'ぐんかん', 0, 2020-12-25, 'a1', 2021-04-01, 'maguro1225');

select * from employee;

select e.employee_code, concat(e.last_name, e.first_name), concat(e.last_kana_name, e.first_kana_name), e.gender,
e.birth_day, s.section_name, e.hire_date from employee e left outer join section s on e.section_code = s.section_code;