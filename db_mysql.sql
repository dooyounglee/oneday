#create table member(m_no int primary key auto_increment,email varchar(100) not null,pass varchar(50) not null,host varchar(10) default 'N')default charset=utf8;

#create table host(m_no int references member(m_no) on delete cascade,email varchar(100) not null,pass varchar(50) not null,phone varchar(30) not null)default charset=utf8;

#create table host(m_no int,email varchar(100) not null,pass varchar(50) not null,phone varchar(30) not null, foreign key(m_no) references member(m_no) on delete cascade)default charset=utf8;

/*create table joinauth(
	email varchar2(100) not null,
	code varchar2(255) not null
);*/

/* CREATE TABLE class(
   class_no int PRIMARY KEY auto_increment, 
   m_no int REFERENCES member(m_no) on delete cascade, 
   title VARCHAR(500) NOT NULL , 
   title_img VARCHAR(100) DEFAULT 'default_title.PNG', 
   content VARCHAR(4000) NOT NULL, 
   price int NOT NULL , 
   address VARCHAR(1000), 
    address_detail VARCHAR(1000), 
   class_day VARCHAR(20), 
   class_time VARCHAR(20), 
   maxperson int NOT NULL , 
   reg_date datetime,
   possible int not null
)default charset=utf8;*/

drop table class;
CREATE TABLE class(
   class_no int PRIMARY KEY auto_increment, 
   m_no int REFERENCES member(m_no) on delete cascade, 
   title VARCHAR(500) NOT NULL , 
   title_img VARCHAR(100) DEFAULT 'default_title.PNG', 
   content VARCHAR(4000) NOT NULL, 
   price int NOT NULL , 
   address VARCHAR(1000), 
   address_detail VARCHAR(1000), 
   reg_date datetime
)default charset=utf8;

drop table subclass;
create table subclass(
	sc_no int primary key auto_increment,
	class_no int references class(class_no) on delete cascade,
	class_day VARCHAR(20), 
	class_time VARCHAR(20), 
	maxperson int NOT NULL,
	possible int not null
)default charset=utf8;

#drop table book;
/*create table book(
	b_no int primary key auto_increment,
	m_no int references member(m_no) on delete cascade,
	class_no int references class(class_no) on delete cascade,
	reg_date datetime
)default charset=utf8;*/
