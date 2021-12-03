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

