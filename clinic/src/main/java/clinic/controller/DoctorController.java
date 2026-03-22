package clinic.controller;

import clinic.model.Doctor;
import clinic.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // POST - Add Doctor
    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    // GET - Get All Doctors
    @GetMapping
    public List<Doctor> getDoctors() {
        return doctorService.getAllDoctors();
    }
}