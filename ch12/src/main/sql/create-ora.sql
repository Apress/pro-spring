create table Accounts (
	AccountId number not null,
	AccountNumber varchar(20) not null,
	SortCode varchar(10) not null,
	Balance decimal(10, 2) not null,
	constraint PK_AccountId primary key (AccountId)
)

create sequence Accounts_AccountId_Seq;

create unique index IX_Accounts_NumberSortCode on Accounts (AccountNumber, SortCode);

create table History (
	HistoryId number not null,
	Account int not null,
	Operation varchar(50) not null,
	Amount decimal(10, 2) not null,
	TransactionDate timestamp not null,
	TargetAccount int null,
	constraint PK_HistoryId primary key (HistoryId),
	constraint FK_Account foreign key (Account) references Accounts(AccountId)
)

create sequence History_HistoryId_Seq;

create index IX_History_Account on History (Account);
