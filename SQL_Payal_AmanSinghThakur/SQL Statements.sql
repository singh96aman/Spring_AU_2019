/* Database Commands */

create database taxiManagementSystem;

use taxiManagementSystem;

/* Create Table */

create table Taxi(
	taxiNumber varchar(10) primary key,
    driverName varchar(50) not null,
    driverRating numeric not null,
    carType varchar(50) not null
);

create table Customer(
	customerID varchar(10) primary key,
    customerName varchar(50) not null,
    customerRating numeric not null
);

create table Website(
	name varchar(50) primary key,
    taxiNumber varchar(10) not null,
    customerID varchar(10) not null,
    routeTaken varchar(50) not null,
    amountPaid float not null,
    foreign key(taxiNumber) references Taxi(taxiNumber),
    foreign key(customerID) references Customer(customerID)
);

/*Insert*/

INSERT INTO `taximanagementsystem`.`customer` (`customerID`, `customerName`, `customerRating`) VALUES ('pqr123', 'Aman Singh', '5');
INSERT INTO `taximanagementsystem`.`customer` (`customerID`, `customerName`, `customerRating`) VALUES ('abc456', 'Naman Singh', '3');
INSERT INTO `taximanagementsystem`.`customer` (`customerID`, `customerName`, `customerRating`) VALUES ('af2322', 'Khaman Sing', '2');
INSERT INTO `taximanagementsystem`.`customer` (`customerID`, `customerName`, `customerRating`) VALUES ('wq23q', 'Baman Singh', '5');
INSERT INTO `taximanagementsystem`.`customer` (`customerID`, `customerName`, `customerRating`) VALUES ('as12ss', 'Sanam Singh', '4');


INSERT INTO `taximanagementsystem`.`taxi` (`taxiNumber`, `driverName`, `driverRating`, `carType`) VALUES ('HR123PQ', 'Suresh', '4', 'Sedan');
INSERT INTO `taximanagementsystem`.`taxi` (`taxiNumber`, `driverName`, `driverRating`, `carType`) VALUES ('CHD1231', 'Naresh', '5', 'SUV');
INSERT INTO `taximanagementsystem`.`taxi` (`taxiNumber`, `driverName`, `driverRating`, `carType`) VALUES ('BNG2213', 'Manish', '1', 'Hatchback');
INSERT INTO `taximanagementsystem`.`taxi` (`taxiNumber`, `driverName`, `driverRating`, `carType`) VALUES ('LKO2312', 'Satish', '3', 'SUV');
INSERT INTO `taximanagementsystem`.`taxi` (`taxiNumber`, `driverName`, `driverRating`, `carType`) VALUES ('GUJ3242', 'Jignesh', '4', 'Sedan');

INSERT INTO `taximanagementsystem`.`website` (`name`, `taxiNumber`, `customerID`, `routeTaken`, `amountPaid`) VALUES ('Uber123', 'BNG2213', 'pqr123', 'Marathalli Bridge', 200);
INSERT INTO `taximanagementsystem`.`website` (`name`, `taxiNumber`, `customerID`, `routeTaken`, `amountPaid`) VALUES ('OLA23', 'HR123PQ', 'as12ss', 'Bellandur NH4', 140);
INSERT INTO `taximanagementsystem`.`website` (`name`, `taxiNumber`, `customerID`, `routeTaken`, `amountPaid`) VALUES ('OLA56', 'GUJ3242', 'wq23q', 'KormanglatoAESClayout', 100);
INSERT INTO `taximanagementsystem`.`website` (`name`, `taxiNumber`, `customerID`, `routeTaken`, `amountPaid`) VALUES ('Uber321', 'LKO2312', 'abc456', 'PESIT to Accolite', 350);
INSERT INTO `taximanagementsystem`.`website` (`name`, `taxiNumber`, `customerID`, `routeTaken`, `amountPaid`) VALUES ('OLA123', 'CHD1231', 'af2322', 'AccoliteToCisco', 10000);

/* Check */
alter table customer add constraint customerRating check (customerRating <=5);

/* Alter Statement */

alter table customer modify customerRating int;

alter table taxi modify driverRating int;

/*Select Statement*/

select * from customer;

select * from taxi;

select * from website;

/*Cross Multiplication (Join) */

select * from customer join taxi; 

select * from customer join website;

select * from customer as cust inner join website as web where cust.customerID = web.customerID;

select * from taxi as tax inner join website as web where tax.taxiNumber = web.taxiNumber;

/* WHERE Clause */

select * from taxi where driverRating > 3;

select * from customer where customerRating >3;

/* Having Clause */

select * from taxi having driverRating >3;

/* Using Aggregate Functions */

select avg(driverRating) as Driver, avg(customerRating) as Customer from taxi, customer;

/* Creating View and viewing a view */


create view total_info as select avg(driverRating) as Driver, avg(customerRating) as Customer from taxi, customer;

select * from total_info;

/* LIKE & BETWEEN & EXISTS syntax */

select * from customer, taxi where customerName like '%aman Singh';

select * from taxi where driverRating between 3 and 5;

select driverName from taxi
where exists
(select driverRating from taxi where driverRating>3);

/* STORED PROCEDURE AND UPDATE */
 
create procedure procedure_addOneTORating as update taxi set driverRating = driverRating + 1 where driverRating <3;
