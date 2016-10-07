drop table Test;
drop table CustomerPermissions;
drop table CustomerAddresses;
drop table Permissions;
drop table Customers;

create table Test (
	TestId serial not null,
	Name varchar(50) not null, 
	RunDate timestamp not null,

	constraint PK_TestId primary key (TestId)
);

create table Customers (
	CustomerId serial not null,
	FirstName varchar(50) not null,
	LastName varchar(50) not null,
	
	constraint PK_CustomerId primary key (CustomerId)
);

create table CustomerAddresses (
	CustomerAddressId serial not null,
	Customer int not null,
	Line1 varchar(50) not null,
	Line2 varchar(50) not null,
	City varchar(50) not null,
	PostCode varchar(50) not null,
	
	constraint PK_CustomerAddressId primary key (CustomerAddressId),
	constraint FK_Customer foreign key (Customer) references Customers (CustomerId) on delete cascade on update cascade
);

create table Permissions (
	PermissionId int not null,
	Name varchar(50) not null,
	
	constraint PK_PermissionId primary key (PermissionId)
);

create table CustomerPermissions (
	CustomerPermissionId serial not null,
	Permission int not null,
	Customer int not null,
	
	constraint PK_CustomerPermissionId primary key (CustomerPermissionId),
	constraint PK_Permission foreign key (Permission) references Permissions(PermissionId) on delete cascade,
	constraint PK_Customer foreign key (Customer) references Customers(CustomerId) on delete cascade
);

insert into Test (Name, RunDate) values ('foo', '2004-01-01');

insert into Customers (FirstName, LastName) values ('Jan', 'Machacek');
insert into Customers (FirstName, LastName) values ('Rob', 'Harrop');
insert into CustomerAddresses (Customer, Line1, Line2, City, PostCode) values (1, 'Line 1', 'Line 2', 'Manchester', 'M1 4HH');
insert into CustomerAddresses (Customer, Line1, Line2, City, PostCode) values (1, 'Line 1', 'Line 2', 'Hradec Kralove', '500 04');
insert into CustomerAddresses (Customer, Line1, Line2, City, PostCode) values (2, 'Line 1', 'Line 2', 'Denton', 'SK1 2AB');
insert into Permissions (PermissionId, Name) values (1, 'View Customer');
insert into Permissions (PermissionId, Name) values (2, 'Edit Customer');
insert into Permissions (PermissionId, Name) values (3, 'Delete Customer');
insert into CustomerPermissions (Permission, Customer) values (1, 1);
insert into CustomerPermissions (Permission, Customer) values (2, 1);
insert into CustomerPermissions (Permission, Customer) values (3, 1);
insert into CustomerPermissions (Permission, Customer) values (1, 2);

alter table Test add column Version int not null default 0;