CREATE SCHEMA tenant1;
CREATE SCHEMA tenant2;

CREATE TABLE tenant1.Person (
    id int,
    name varchar(255)
);

CREATE TABLE tenant2.Person (
    id int,
    name varchar(255)
);

insert into tenant1.Person values (1,'Tenant1');
insert into tenant2.Person values (1,'tenant2');