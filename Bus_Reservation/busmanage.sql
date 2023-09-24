CREATE DATABASE IF NOT EXISTS busmanagement;
USE busmanagement;


user_details:
-------------

CREATE TABLE user_details(
id INT(11) NOT NULL AUTO_INCREMENT ,
firstname VARCHAR(50) NOT NULL ,
lastname VARCHAR(50) NOT NULL ,
username VARCHAR(50) NOT NULL ,
mobile VARCHAR(20) NOT NULL ,
email VARCHAR(50) NOT NULL , 
password VARCHAR(50) NOT NULL ,
PRIMARY KEY (id)
) ENGINE = InnoDB; 

bus_booking:
------------

CREATE TABLE bus_booking (
id INT(11) NOT NULL AUTO_INCREMENT , 
name VARCHAR(100) NOT NULL ,
age INT(11) NOT NULL , 
gender VARCHAR(100) NOT NULL , 
phone_no VARCHAR(100) NOT NULL , 
from_start VARCHAR(100) NOT NULL , 
to_end VARCHAR(100) NOT NULL , 
date VARCHAR(100) NOT NULL , 
seat INT(11) NOT NULL , 
PRIMARY KEY (id)) ENGINE = InnoDB; 


employee_details:
-----------------

CREATE TABLE employee_details(
id INT(11) NOT NULL AUTO_INCREMENT , 
firstname VARCHAR(100) NOT NULL ,
lastname VARCHAR(100) NOT NULL , 
phone_number VARCHAR(100) NOT NULL ,
PRIMARY KEY (id)) ENGINE = InnoDB; 

bus_details:
-------------

CREATE TABLE bus_details (
id INT(11) NOT NULL AUTO_INCREMENT , 
bus_no VARCHAR(100) NOT NULL ,
moment VARCHAR(100) NOT NULL,
busfrom VARCHAR(100) NOT NULL ,
busto VARCHAR(100) NOT NULL , 
depart_date VARCHAR(100) NOT NULL , 
depart_time VARCHAR(100) NOT NULL , 
price VARCHAR(100) NOT NULL , 
total_seat VARCHAR(100) NOT NULL ,
PRIMARY KEY (id)) ENGINE = InnoDB; 

bus_assign:
------------

CREATE TABLE bus_assign(
id INT(11) NOT NULL AUTO_INCREMENT ,
employee_id VARCHAR(100) NOT NULL ,
bus_no VARCHAR(100) NOT NULL,
PRIMARY KEY (id)) ENGINE = InnoDB;

admin_details:
---------------

CREATE TABLE admin_details (
id INT(11) NOT NULL AUTO_INCREMENT , 
name VARCHAR(100) NOT NULL ,
username VARCHAR(100) NOT NULL, 
password VARCHAR(100) NOT NULL ,
PRIMARY KEY (id)) ENGINE = InnoDB;
