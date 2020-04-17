drop table T_PRODUCT if exists;

create table T_PRODUCT (NAME varchar(50) not null,
			IMAGE varchar(1024), 
			PRIMARY KEY (NAME));

