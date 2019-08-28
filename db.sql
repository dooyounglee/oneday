--DROP TABLE oneday;
--DROP SEQUENCE seq_member;
--DROP TABLE host;
--DROP TABLE class;
--DROP SEQUENCE seq_class;
--DROP TABLE joinauth;

CREATE TABLE oneday(
	m_no NUMBER PRIMARY KEY, 
	email VARCHAR2(100) NOT NULL, 
	pass VARCHAR2(50) NOT NULL, 
	host VARCHAR2(10) DEFAULT 'N', 
    CHECK (host in ('Y','N'))
);

create sequence seq_member;

CREATE TABLE host(
	m_no NUMBER REFERENCES member on delete cascade PRIMARY key , 
	email VARCHAR2(100) NOT NULL, 
	pass VARCHAR2(50) NOT NULL, 
	phone VARCHAR2(30) NOT NULL
);
  
CREATE TABLE class(
	class_no NUMBER PRIMARY KEY, 
	m_no NUMBER REFERENCES member on delete cascade, 
	title VARCHAR2(500) NOT NULL , 
	title_img VARCHAR2(100) DEFAULT 'default_title.PNG', 
	content VARCHAR2(4000) NOT NULL, 
	price NUMBER NOT NULL , 
	address VARCHAR2(1000), 
	address_detail VARCHAR2(1000), 
	class_day VARCHAR2(20), 
	class_time VARCHAR2(20), 
	maxperson NUMBER NOT NULL,
	reg_date DATE,
	possible NUMBER
);

CREATE SEQUENCE seq_class;

create table joinauth(
   email varchar2(100) not null,
   code varchar2(255) not null
);

--DELETE FROM joinauth;

CREATE TABLE book(
	b_no int PRIMARY KEY,
	m_no int REFERENCES MEMBER ON DELETE CASCADE,
	class_no int REFERENCES class ON DELETE CASCADE,
	reg_date DATE
);

CREATE SEQUENCE seq_book;
