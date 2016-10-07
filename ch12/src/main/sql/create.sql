drop table Accounts;
drop table History;

create table Accounts (
	AccountId serial not null,
	AccountNumber varchar(20) not null,
	SortCode varchar(10) not null,
	Balance decimal(10, 2) not null,
	
	constraint PK_AccountId primary key (AccountId)
);

create unique index IX_Accounts_NumberSortCode on Accounts using btree(AccountNumber, SortCode);

create table History (
	HistoryId serial not null,
	Account int not null,
	Operation varchar(50) not null,
	Amount decimal(10, 2) not null,
	TransactionDate timestamp not null,
	TargetAccount int null,
	
	constraint PK_HistoryId primary key (HistoryId),
	constraint FK_Account foreign key (Account) references Accounts(AccountId)
);

create index IX_History_Account on History using btree(Account);
