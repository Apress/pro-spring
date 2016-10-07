drop table if exists Tests;
drop table if exists TestDetails;

create table Tests (
    TestId int not null auto_increment,
    Name varchar(50) not null,
    constraint PK_TestId primary key (TestId)
) type=InnoDb;

insert into Tests (Name) values ('One');
insert into Tests (Name) values ('Two');
insert into Tests (Name) values ('Three');
insert into Tests (Name) values ('Four');
insert into Tests (Name) values ('Five');

create table TestDetails (
	TestDetailId int not null auto_increment,
	Test int not null,
	Data varchar(255) not null,
	
	index(Test),
	constraint PK_TestDetailId primary key (TestDetailId),
	constraint FK_Test foreign key (Test) references Tests (TestId)
) type=InnoDb;

insert into TestDetails (Test, Data) values (1, 'Success');
insert into TestDetails (Test, Data) values (1, 'Another result');
insert into TestDetails (Test, Data) values (1, 'More details');

insert into TestDetails (Test, Data) values (2, 'Success');

insert into TestDetails (Test, Data) values (3, 'Success');

insert into TestDetails (Test, Data) values (4, 'Success');

insert into TestDetails (Test, Data) values (5, 'Detail 1');
insert into TestDetails (Test, Data) values (5, 'Detail 2');
insert into TestDetails (Test, Data) values (5, 'Detail 3');
insert into TestDetails (Test, Data) values (5, 'Detail 4');