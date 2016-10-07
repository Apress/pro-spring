drop table if exists CommentAttachments;
drop table if exists EntryAttachments;
drop table if exists Comments;
drop table if exists Attachments;
drop table if exists Entries;
drop table if exists Audit;
drop table if exists Users;

create table Users (
	UserId int not null auto_increment,
	
	Username varchar(32) not null,
	Password varchar(32) not null,
	Email varchar(64) not null,
	Type int not null,
	
	unique(Username),
	
	constraint PK_UserId primary key (UserId)
) type = InnoDb;

create table Entries (
	EntryId int not null auto_increment,
	
	Subject varchar(50) not null,
	Body text not null,
	PostDate timestamp not null,
	
	constraint PK_EntryId primary key (EntryId)
) type = InnoDb;

create table Comments (
	CommentId int not null auto_increment,
	
	Subject varchar(50) not null,
	Body text not null,
	PostDate timestamp not null,
	Entry int not null,
	ReplyTo int null,
	PostedBy int null,
	
	index (ReplyTo),
	index (PostedBy),
	index (Entry),
	
	constraint PK_CommentId primary key (CommentId),
	constraint FK_ReplyTo foreign key (ReplyTo) references Comments(CommentId) on delete cascade,
	constraint FK_PostedBy foreign key (PostedBy) references Users(UserId) on delete cascade,
	constraint FK_Entry foreign key (Entry) references Entries(EntryId) on delete cascade
) type = InnoDb;

create table Attachments (
	AttachmentId int not null auto_increment,
	
	FileName varchar(255) not null,
	ContentType varchar(50) not null,
	FileData blob not null,
	
	constraint PK_AttachmentId primary key (AttachmentId)
) type = InnoDb;

create table CommentAttachments (
	CommentAttachmentId int not null auto_increment,
	
	Comment int not null,
	Attachment int not null,
	
	index(Comment),
	index(Attachment),
	
	constraint PK_CommentAttachmentId primary key (CommentAttachmentId),
	constraint FK_CA_Comment foreign key (Comment) references Comments(CommentId) on delete cascade,
	constraint FK_CA_Attachment foreign key (Attachment) references Attachments(AttachmentId) on delete cascade
) type = InnoDb;

create table EntryAttachments (
	EntryAttachmentId int not null auto_increment,
	
	Entry int not null,
	Attachment int not null,
	
	index(Entry),
	index(Attachment),
	
	constraint PK_EntryAttachmentId primary key (EntryAttachmentId),
	constraint FK_EA_Entry foreign key (Entry) references Entries(EntryId) on delete cascade,
	constraint FK_EA_Attachment foreign key (Attachment) references Attachments(AttachmentId) on delete cascade
) type = InnoDb;


create table Audit (
	AuditId int not null auto_increment,
	
	User int null,
	AuditDate timestamp not null,
	Data varchar(255) not null,
	
	index(User),

	constraint PK_AuditId primary key (AuditId),
	constraint FK_A_User foreign key (User) references Users(UserId) on delete set null
) type = InnoDb;



-- Initial data

insert into Users (Username, Password, Email, Type) values ('root', 'pwd', 'jan@cakesolutions.net', 1);
insert into Entries (Subject, Body, PostDate) values ('How this book came to be', 'If something''s hard to do then it''s not worth doing. This memorable quite from my personal hero and role-model, Mr. Homer J. Simpson has helped me keep the code as simple as possible.', sysdate());
insert into Entries (Subject, Body, PostDate) values ('Welcome', 'This is the first entry in the blog. It is really exciting to see how Spring makes application programming much, much easier.', sysdate());
insert into Comments (Entry, Subject, Body, PostDate, PostedBy) values (1, 'CS', 'CB', sysdate(), 1);
insert into Comments (Entry, Subject, Body, PostDate, PostedBy) values (1, 'delete-me', 'dme', sysdate(), 1);