create database game;
drop database game;
use game;
create table login
(
	acc varchar(50) ,
    pass varchar(50),
    score int
);
insert into login (acc,pass) values ('nhat','4'),('thao','4'),('ha','4'),('dung','4');
select * from login;
delete from login;
drop table login;

create table question
(
	ques varchar(200),
    ans varchar(200),
    type varchar(200)
);

insert into question (ques,ans,type) values ('Ai la ha?','ha','Human');
insert into question (ques,ans,type) values ('Ai la thao?','thao','Human');
insert into question (ques,ans,type) values ('1+1=?','2','Number');
insert into question (ques,ans,type) values ('1+3=?','4','Number');
drop table question;
select * from question;



show tables in game;


