drop table work_time if exists;

create table work_time (
	employee_code varchar(100) not null,
	work_date date not null,
	start_time time,
	finish_time time,
	working_hours time
);

insert into work_time values();

select * from work_time;