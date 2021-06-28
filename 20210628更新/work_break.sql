drop table work_break if exists;

create table work_break (
	employee_code varchar(100) not null,
	work_date date not null,
	break_start_time time,
	break_finish_time time,
	break_time time
);

insert into work_break values();

select * from work_break;