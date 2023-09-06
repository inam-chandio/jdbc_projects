create database Students_Department;
use Students_Department;

create table department(
	dep_ID int(11) primary key,
    dep_name varchar(50),
    dep_code varchar(20)
);

insert into department(dep_ID, dep_name, dep_code)
	values(101, 'Computer Systems', 'CSE');

create database student_management;

use student_management;


create table department(
	dep_ID int(11) primary key,
    dep_name varchar(50),
    dep_code varchar(20)
);
insert into department(dep_ID, dep_name, dep_code)
	values(04, 'Computer Systems', '808'),
		  (08, 'Petrolium', '987'),
		  (12, 'Civil', '101'),
          (16, 'Electrical Engineering', '187'),
          (20, 'Telicom', '123'),
          (24, 'Textile', '890');

select * from department;


create table course(
	course_id int(11) primary key,
    course_name varchar(40),
    course_marks int(11)
);



insert into course(course_id, course_name,  course_marks)
	values(500, 'Computer Architure',100),
		  (501, 'Data Structure', 100),
          (502, 'Electronics',  100),
          (503, 'Java Development', 100),
          (504, 'C#',  100),
          (506, 'DLD',  100);
select * from course;




create table students(
	st_id int(11) primary key,
	st_rollNumber varchar(20),
    st_name varchar(30),
    st_fatherName varchar(30),
    st_age int(11),
    st_email varchar(40),
    st_mobile_Number int(13),
    dep_ID int(11),
    foreign key(dep_ID) references department(dep_ID)
);

insert into student_management.students(st_id, st_rollNumber, st_name, st_fathername, st_age, st_email,st_mobile_Number, dep_ID)
	values(01, '20SCSE007', 'Saqib Ali', 'Ghulab khan', 23, 'saqib2@gmail.com', 0340390,4),
		  (03, '20CSE003', 'Haseeb', 'Wali Muhammad', 22, 'haseeb1@gmail.com', 3030198,4),
          (05, '20CSE019', 'Tauqeer Ali', 'Mula Bux', 24, 'tauqeerali19@gmail.com', 0301981,12),
          (07, '20CSE078', 'Amir Ali', 'Shadi Khan', 28, 'aamir2@gmail.com', 03089087,8),
          (09, '20CSE008', 'Inam Ali', 'Inam Alii', 20, 'inamalichandio08@gmail.com', 03332098,16),
          (11, '20CSE072', 'Zulfiquar Ali', 'Mumtaz Ali', '21', 'zulfi1@gmail.com', 0301129988,16);

select * FROM student;

            

create table studentCourse( 
	st_id int(11),
    course_id int(11),
    marks_Obtained int(11),
    foreign key(st_id) references students(st_id),
    foreign key(course_id) references course(course_id)
);


insert into studentCourse( st_id, course_id, marks_Obtained)
	values(01, 501, 82),
		  (03, 502, 75),
          (05, 503, 98),
          (07, 504, 69),
          (11, 506, 93);
          


select * from student_course_data;

use student_management_system;


select s.st_name, d.dep_name 
from students s inner join department d 
ON s.dep_ID = d.dep_ID;

select sc.st_id, c.course_name
from studentCourse sc inner join course c
ON sc.course_id = c.course_id;

select s.st_name, c.course_id from students s inner join course c where st_id = (select count(course_id), st_id from studentCourse);

select st_id, sum(marks_obtained) from studentCourse group by st_id;


SELECT * FROM student_management.students;

alter table students drop CONSTRAINT students_ibfk_1;

alter table students add FOREIGN KEY (dep_ID) REFERENCES department(dep_ID) on delete cascade;