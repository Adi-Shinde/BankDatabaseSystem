create database BankManagementSystemDB;

show databases;

use BankManagementSystemDB;

CREATE TABLE signup (
    formno VARCHAR(20),
    name VARCHAR(25),
    father_name VARCHAR(25),
    dob VARCHAR(20),
    gender VARCHAR(20),
    email VARCHAR(35),
    marital_status VARCHAR(20),
    address VARCHAR(40),
    city VARCHAR(25),
    postalcode VARCHAR(20),
    province VARCHAR(30)
); 

CREATE TABLE signuptwo (
    formno2 varchar(10),
    security_question VARCHAR(60),
    security_answers VARCHAR(30),
    educational_qualification VARCHAR(50),
    income_amount VARCHAR(10),
    occupation VARCHAR(18),
    sinnumber VARCHAR(15),
    senior_citizen VARCHAR(5),
    existing_account VARCHAR(5)
);

CREATE TABLE signupthree (
    formno2 varchar(10),
    account_type varchar(40),
    cardnumber varchar(25),
    pinnumber varchar(10),
    service varchar (170)
);

CREATE TABLE login (
    formno2 varchar(10),
    card_number varchar(40),
    pin_number varchar(25)
);

select * from signup;
select * from signuptwo;
select * from signupthree;
select * from login;

show tables;

#TRUNCATE TABLE signup;
#TRUNCATE TABLE signuptwo;
#TRUNCATE TABLE signupthree;
#DROP DATABASE BankManagementSystemDB;
