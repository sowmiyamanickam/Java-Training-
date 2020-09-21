use registration;
CREATE TABLE user(
  `loginId` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`loginId`)
);
insert into User(loginId, password) values('Geetha', 'geetha123');
insert into User(loginId, password) values('Gomathi', '123gomathi');
insert into User(loginId, password) values('abi', 'bi@12');
insert into User(loginId, password) values('priya', '0987654321');
insert into User(loginId, password) values('Jaba', 'priya@12');
desc user;
