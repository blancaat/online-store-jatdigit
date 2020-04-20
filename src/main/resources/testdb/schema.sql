drop table T_PRODUCT if exists;

create table T_PRODUCT (NAME varchar(1024) not null,
			TITLE varchar(1024),
			PRICE int,
			DESCRIPTION varchar(9000),
			DETAILS varchar(9000),
			MEASURE varchar(1024),
			PRIMARY KEY (NAME));

