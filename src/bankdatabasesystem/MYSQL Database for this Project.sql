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

select * from signuptwo;
select * from signup;

show tables;

#TRUNCATE TABLE signup;
#TRUNCATE TABLE signuptwo;
#DROP DATABASE BankManagementSystemDB;
