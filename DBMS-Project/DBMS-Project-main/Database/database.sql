-- Create database
CREATE DATABASE IF NOT EXISTS university_management;
USE university_management;

-- -------------------
-- Admin Login Table
-- -------------------
CREATE TABLE IF NOT EXISTS Login (
    Username VARCHAR(50) PRIMARY KEY,
    Password VARCHAR(100) NOT NULL
);

-- Insert default admin account
INSERT INTO Login (Username, Password)
VALUES ('<username>', '<password>');

-- -------------------
-- Department Table
-- -------------------
CREATE TABLE IF NOT EXISTS Department (
    DepartmentID INT PRIMARY KEY AUTO_INCREMENT,
    DepartmentName VARCHAR(100) NOT NULL
);

-- Sample departments
INSERT INTO Department (DepartmentName) VALUES
('Computer Science'),
('Electronics and Telecommunication'),
('Mechanical'),
('IT'),
('AIML'),
('AIDS'),
('ECE');

-- -------------------
-- Teacher Table (used by AddFaculty.java)
-- -------------------
CREATE TABLE IF NOT EXISTS Teacher (
    Name VARCHAR(100) NOT NULL,
    FathersName VARCHAR(100),
    EmployeeID VARCHAR(20) PRIMARY KEY,
    Address VARCHAR(200),
    DOB DATE,
    Phone VARCHAR(15),
    Email VARCHAR(100),
    Class10Marks DECIMAL(5,2),
    Class12Marks DECIMAL(5,2),
    AadharNumber VARCHAR(20) UNIQUE,
    Course VARCHAR(50),
    Department VARCHAR(100)
);

-- -------------------
-- Student Table
-- -------------------
CREATE TABLE IF NOT EXISTS Student (
    StudentID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    FathersName VARCHAR(100),
    Email VARCHAR(100) UNIQUE,
    Phone VARCHAR(15),
    DateOfBirth DATE,
    AadharNumber VARCHAR(20) UNIQUE,
    RollNo VARCHAR(20) UNIQUE,
    Class10Marks DECIMAL(5,2),
    Class12Marks DECIMAL(5,2),
    Course VARCHAR(50)
);

-- -------------------
-- Course Table
-- -------------------
CREATE TABLE IF NOT EXISTS Course (
    CourseID INT PRIMARY KEY AUTO_INCREMENT,
    CourseName VARCHAR(100) NOT NULL,
    Credits INT,
    DepartmentID INT,
    FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID)
);

-- -------------------
-- Enrollment Table
-- -------------------
CREATE TABLE IF NOT EXISTS Enrollment (
    EnrollmentID INT PRIMARY KEY AUTO_INCREMENT,
    StudentID INT,
    CourseID INT,
    EnrollmentDate DATE,
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID),
    FOREIGN KEY (CourseID) REFERENCES Course(CourseID)
);

-- -------------------
-- Marks Table
-- -------------------
CREATE TABLE IF NOT EXISTS Marks (
    MarkID INT PRIMARY KEY AUTO_INCREMENT,
    StudentID INT,
    CourseID INT,
    Grade VARCHAR(5),
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID),
    FOREIGN KEY (CourseID) REFERENCES Course(CourseID)
);

-- -------------------
-- Leave Applications (for students & teachers)
-- -------------------
CREATE TABLE IF NOT EXISTS LeaveApplications (
    LeaveID INT PRIMARY KEY AUTO_INCREMENT,
    UserType ENUM('Student','Teacher'),
    UserID VARCHAR(20),
    Duration VARCHAR(50),
    LeaveDate DATE
);
