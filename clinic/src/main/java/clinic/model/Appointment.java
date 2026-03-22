package clinic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;

    @NotNull
    @Future
    private LocalDateTime appointmentTime;

    private String status;

    // Getters
    public Long getId() { return id; }
    public Doctor getDoctor() { return doctor; }
    public Patient getPatient() { return patient; }
    public LocalDateTime getAppointmentTime() { return appointmentTime; }
    public String getStatus() { return status; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
    public void setPatient(Patient patient) { this.patient = patient; }
    public void setAppointmentTime(LocalDateTime appointmentTime) { this.appointmentTime = appointmentTime; }
    public void setStatus(String status) { this.status = status; }
}
