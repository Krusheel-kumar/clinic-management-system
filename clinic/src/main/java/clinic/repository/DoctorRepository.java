package clinic.repository;

import clinic.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    // ✅ REQUIRED for login validation
    Optional<Doctor> findByEmail(String email);
}
