Create table students_info(
    id bigserial primary key ,
    name varchar(50),
    course_name varchar(50),
    course_cost integer,
    telephone_number varchar(20)
);

insert into students_info(name, course_name, course_cost, telephone_number)
values ('Bob','Information system',120000,'89996664422'),
       ('Max','Mathematician',80000,'89098885522')