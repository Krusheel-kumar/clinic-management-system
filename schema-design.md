# Database Schema Design - Smart Clinic Management System

## Doctor Table
CREATE TABLE doctor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    specialization VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(15),
    available_times VARCHAR(50)
);

## Patient Table
CREATE TABLE patient (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(15),
    address VARCHAR(255)
);

## Appointment Table
CREATE TABLE appointment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    doctor_id INT,
    patient_id INT,
    FOREIGN KEY (doctor_id) REFERENCES doctor(id),
    FOREIGN KEY (patient_id) REFERENCES patient(id)
);
