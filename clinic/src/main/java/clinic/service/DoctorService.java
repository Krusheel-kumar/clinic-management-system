package clinic.service;

import clinic.model.Doctor;
import clinic.repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // ✅ Save doctor
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // ✅ Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // ✅ REQUIRED: Get available slots by doctor and date
    public List<String> getAvailableSlots(Long doctorId, LocalDate date) {
        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);

        if (doctor == null) {
            return List.of();
        }

        // assuming availableTimes stored as comma-separated values
        return Arrays.asList(doctor.getAvailableTimes().split(","));
    }

    // ✅ REQUIRED: Validate doctor login
    public boolean validateDoctorLogin(String email, String phone) {
        Doctor doctor = doctorRepository.findByEmail(email);

        if (doctor == null) {
            return false;
        }

        return doctor.getPhone().equals(phone);
    }
}
