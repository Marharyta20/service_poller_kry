# Service poller

## Build
For building application you should run next command line
mvn spring-boot:run

## Run database
For starting database locally run next command line
sudo mysql --password

## Create database
Use this command for database and table creation:

CREATE DATABASE services;
USE services;
CREATE TABLE services (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(500) NOT NULL,
url VARCHAR(5000) NOT NULL,
status VARCHAR(500) NOT NULL,
creationTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

## Create user
Use this script to create user and grant permissions

create user 'dev'@'%' identified by 'secret';

## Run local
For starting application locally run next command line
npm start

## Run tests
For running unit tests you should run next command line
