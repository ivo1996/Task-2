insert into person(id, first_name, last_name, birth_date, phone, email, username, password, active)
 values (1, 'Ivelin','Dimitrov', '1996-03-30', '0893956544', 'ivelin.dimitrov9@gmail.com', 'ivelin', '$2a$10$dp3rAOjA6ftCvEOhOTjhqOymfSUpMt945Orf81HHBB7wo3IhxHpUe', 1);
insert into role values(1,'USER');
insert into role values(2,'ADMIN');
insert into role values(3,'EMPLOYEE');
insert into role values(4,'EMPLOYER');
insert into user_role values (1,2);
insert into department values(1,'IT');
