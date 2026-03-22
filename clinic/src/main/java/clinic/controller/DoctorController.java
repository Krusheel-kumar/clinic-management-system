package clinic.controller;

import clinic.model.Doctor;
import clinic.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService service;

    // ✅ REQUIRED METHOD (VERY IMPORTANT)
    @GetMapping("/{user}/{doctorId}/{date}/{token}")
    public Object getDoctorAvailability(
            @PathVariable String user,
            @PathVariable Long doctorId,
            @PathVariable String date,
            @PathVariable String token) {

        // Token validation
        if (!service.validateToken(token, user)) {
            return "Invalid Token";
        }

        LocalDate localDate = LocalDate.parse(date);

        return service.getAvailableSlots(doctorId, localDate);
    }
}
