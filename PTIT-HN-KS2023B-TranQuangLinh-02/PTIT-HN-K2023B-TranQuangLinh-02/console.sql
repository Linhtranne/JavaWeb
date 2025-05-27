DROP DATABASE IF EXISTS hackathon;
CREATE DATABASE hackathon;
USE hackathon;

CREATE TABLE Department
(
    department_id INT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(50) NOT NULL,
    status BIT NOT NULL DEFAULT 1,
    description TEXT
);
CREATE TABLE Employee(
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone_number VARCHAR(20) UNIQUE NOT NULL,
    avatar_url VARCHAR(255) ,
    status BIT NOT NULL DEFAULT 1,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES Department(department_id) ON DELETE SET NULL
);

CREATE DATABASE IF NOT EXISTS DepartmentManagement;
USE DepartmentManagement;

CREATE TABLE departments (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             name VARCHAR(255) NOT NULL,
                             description TEXT,
                             status ENUM('ACTIVE', 'INACTIVE') NOT NULL,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DELIMITER $$
CREATE PROCEDURE GetAllDepartments()
BEGIN
    SELECT * FROM departments ORDER BY created_at DESC;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE GetDepartmentById(IN dept_id INT)
BEGIN
    SELECT * FROM departments WHERE id = dept_id;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE AddDepartment(IN dept_name VARCHAR(255), IN dept_description TEXT, IN dept_status ENUM('ACTIVE', 'INACTIVE'))
BEGIN
    INSERT INTO departments (name, description, status) VALUES (dept_name, dept_description, dept_status);
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE UpdateDepartment(IN dept_id INT, IN dept_name VARCHAR(255), IN dept_description TEXT, IN dept_status ENUM('ACTIVE', 'INACTIVE'))
BEGIN
    UPDATE departments
    SET name = dept_name, description = dept_description, status = dept_status
    WHERE id = dept_id;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE DeleteDepartment(IN dept_id INT)
BEGIN
    DELETE FROM departments WHERE id = dept_id;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE SearchDepartmentsByName(IN search_name VARCHAR(255))
BEGIN
    SELECT * FROM departments WHERE name LIKE search_name;
END$$
DELIMITER ;