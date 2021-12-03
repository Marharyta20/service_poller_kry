# Service poller
The content of frontend folder is in this repo: https://github.com/Marharyta20/service_poller_kry_1
## Build
For building application you should run next command lines
mvn clean install
mvn spring-boot:run

## Run database
For starting database locally run next command line
sudo mysql --password

## Create database
Use this command for database and table creation (You can find it in init.sql file):

CREATE DATABASE services;
GRANT ALL PRIVILEGES ON services.* TO 'dev'@'%' IDENTIFIED BY 'secret';
USE services; 
CREATE TABLE services ( 
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
name VARCHAR(500) NOT NULL, 
url VARCHAR(5000) NOT NULL, 
status VARCHAR(500) NOT NULL, 
creationTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL );
INSERT INTO services (name, url, status, creationTime)
VALUES
('Service1', 'http://host:1111/services/myService1', 'OK', 2021-12-01),
('Service2', 'http://host:1111/services/myService2', 'OK', 2021-11-10),
('Service3', 'http://host:1111/services/myService3', 'FAIL', 2021-02-01),
('Service4', 'http://host:1111/services/myService4', 'OK', 2020-12-01);

## Create user
Use this script to create user and grant permissions

create user 'dev'@'%' identified by 'secret';

## Run local
For starting application locally run next command line from /service_poller_kry/frontend
npm start

## Run tests
For running unit tests you should run next command line
mvn test
