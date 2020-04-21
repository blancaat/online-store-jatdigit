drop table T_PRODUCT if exists;

create table T_PRODUCT (NAME varchar(1024) not null,
			TITLE varchar(1024),
			QUANTITY int,
			PRICE float,
			DESCRIPTION varchar(9000),
			DETAILS varchar(9000),
			MEASURE varchar(1024),
			COLLECTION varchar(1024),
			PRIMARY KEY (NAME));

