package clinic.repository;

import clinic.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    // ✅ REQUIRED (main)
    Optional<Patient> findByEmail(String email);

    // ✅ EXTRA (strong answer)
    Optional<Patient> findByPhone(String phone);

    // ✅ BONUS (best practice)
    Optional<Patient> findByEmailOrPhone(String email, String phone);
}
