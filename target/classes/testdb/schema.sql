drop table T_PRODUCT if exists;

create table T_PRODUCT (NAME varchar(50) not null,
			IMAGE varchar(100) not null, 
			PRIMARY KEY (NAME, IMAGE));

