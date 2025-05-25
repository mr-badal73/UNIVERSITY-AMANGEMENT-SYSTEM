create database universitymanagement;
use universitymanagement;
show tables;

create table login(username varchar(30), password username varchar(30));
select * from login;
create table teacher(name varchar(30), fname varchar(30), empID varchar(30), address varchar(30), phone varchar(30), email varchar(30), class_X varchar(30), class_XII varchar(30)aadhar varchar(30), education varchar(30), department varchar(30));
select * from teacher;
create table student(name varchar(30), fname varchar(30), rollno varchar(30), address varchar(30), phone varchar(30), email varchar(30), class_X varchar(30), class_XII varchar(30)aadhar varchar(30), course varchar(30), branch varchar(30));
select * from student;
create table studentleave(rollno varchar(30), date varchar(30), time varchar(30));
select * from studentleave;
create table teacherleave(empID varchar(30), date varchar(30), time varchar(30));
select * from teacherleave;
create table subject(rollno varchar(30),semester varchar(30), subj1 varchar(30),  subj2 varchar(30),  subj3 varchar(30),  subj4 varchar(30),  subj5 varchar(30));
select * from subject;
create table marks(rollno varchar(30),semester varchar(30),  mrk1 varchar(30), mrk2 varchar(30),  mrk3 varchar(30),  mrk4 varchar(30),  mrk5 varchar(30));
select * from marks;
create table fee(course varchar(20), semester1 varchar(20), semester2 varchar(20), semester3 varchar(20), semester4 varchar(20), semester5 varchar(20), semester6 varchar(20), semester7 varchar(20), semester8 varchar(20));


insert into fee values("BTech", "49000", "43000","43000","43000","43000","43000","43000","43000");

insert into fee values("Bsc", "44000", "35000","35000","35000","35000","35000","","");

insert into fee values("BCA", "39000", "34000","34000","34000","34000","34000","","");

insert into fee values("MTech", "70000", "60000","60000","60000","","","","");

insert into fee values("MSc", "44000", "45000","45000","45000","","","","");

insert into fee values("MCA", "66000", "42000","42000","49000","","",""."");

insert into fee values("Bcom", "32000", "20000","20000","20000","20000","20000","","");

insert into fee values("Mcom", "46000", "30000","30000","30000","","","","");
select * from fee;
create table feecollege(rollno varchar(30), course varchar(30), branch varchar(30), semester varchar(30),total varchar(30));
select * from feecollege;