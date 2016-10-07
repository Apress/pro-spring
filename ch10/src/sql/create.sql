drop table Test;
drop table OrderLines;
drop table Orders;
drop table Customers;
drop table CustomerDetails;

create table Test (
	TestId serial not null,
	Name varchar(50) not null, 
	RunDate timestamp not null,

	constraint PK_TestId primary key (TestId)
);

insert into Test (Name, RunDate) values ('foo', '2004-01-01');

create table CustomerDetails (
	CustomerDetailId serial not null,
	Data varchar(255) not null,
	
	constraint PK_CustomerDetailId primary key (CustomerDetailId)
);

create table Customers (
	CustomerId serial not null,
	FirstName varchar(50) not null,
	LastName varchar(50) not null,
	CustomerDetail int not null,
	CustomerGossip int null,
	
	constraint PK_CustomerId primary key (CustomerId),
	constraint FK_CustomerDetail foreign key (CustomerDetail) references CustomerDetails(CustomerDetailId) on delete cascade,
	constraint FK_CustomerGossip foreign key (CustomerGossip) references CustomerDetails(CustomerDetailId) on delete cascade
);

create index IX_Customers_CustomerDetail on Customers using btree (CustomerDetail);
create index IX_Customers_CustomerGossip on Customers using btree (CustomerGossip);

create table Orders (
	OrderId serial not null,
	Customer int not null,
	
	constraint PK_OrderId primary key (OrderId),
	constraint FK_Customer foreign key (Customer) references Customers(CustomerId)
);

create index IX_Orders_Customer on Orders using btree (Customer);

create table OrderLines (
	OrderLineId serial not null,
	"Order" int not null,
	Product varchar(200) not null, 
	Price decimal(10, 2) not null,
	
	constraint PK_OrderLineId primary key (OrderLineId),
	constraint FK_Order foreign key ("Order") references Orders(OrderId)
);

create index IX_OrderLines_Order on OrderLines using btree ("Order");

insert into CustomerDetails (Data) values ('Doeth!');
insert into CustomerDetails (Data) values ('The Force is strong with him');
insert into CustomerDetails (Data) values ('Will tell for a bottle of Tequilla');
insert into Customers (FirstName, LastName, CustomerDetail, CustomerGossip) values ('Jan', 'Machacek', 1, null);
insert into Customers (FirstName, LastName, CustomerDetail, CustomerGossip) values ('Rob', 'Harrop', 2, 3);

insert into Orders (Customer) values (1);
insert into OrderLines ("Order", Product, Price) values (1, 'Punch people over the internet client application', 19.95);
insert into OrderLines ("Order", Product, Price) values (1, 'The Mangelfreuzer Switch', 12.95);