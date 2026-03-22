# Database Schema Design

##  Doctor Table
- id (INT, PRIMARY KEY, AUTO_INCREMENT)
- name (VARCHAR(100))
- specialization (VARCHAR(100))
- email (VARCHAR(100))
- phone (VARCHAR(15))
- available_times (TEXT)


##  Patient Table
- id (INT, PRIMARY KEY, AUTO_INCREMENT)
- name (VARCHAR(100))
- email (VARCHAR(100))
- phone (VARCHAR(15))
- address (TEXT)



##  Appointment Table
- id (INT, PRIMARY KEY, AUTO_INCREMENT)
- doctor_id (INT, FOREIGN KEY REFERENCES doctor(id))
- patient_id (INT, FOREIGN KEY REFERENCES patient(id))
- appointment_time (DATETIME)
- status (VARCHAR(50))


##  Prescription Table (NEW – IMPORTANT)
- id (INT, PRIMARY KEY, AUTO_INCREMENT)
- appointment_id (INT, FOREIGN KEY REFERENCES appointment(id))
- medicines (TEXT)
- notes (TEXT)


##  Relationships

- One Doctor → Many Appointments (1:N)
- One Patient → Many Appointments (1:N)
- One Appointment → One Prescription (1:1

- One Doctor → Many Appointments (1:N)
- One Patient → Many Appointments (1:N)
- One Appointment → One Prescription (1:1)
