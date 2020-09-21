use prf;
create table regtab(FirstName varchar(20) not null, LastName varchar(20),
Address varchar(50) not null, EmailID varchar(40), City varchar(20) not null, State varchar(20) not null,
PetName varchar(20), PhoneNumber numeric(10) not null, PetType varchar(20) not null,
PetAge numeric(2));
desc regtab;
select * from regtab;
