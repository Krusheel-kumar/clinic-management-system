package clinic.service;

import clinic.model.Prescription;
import clinic.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository repository;

    public Prescription savePrescription(Prescription p) {
        return repository.save(p);
    }

    public List<Prescription> getAllPrescriptions() {
        return repository.findAll();
    }

    public List<Prescription> getByPatientId(Long patientId) {
        return repository.findByPatientId(patientId);
    }
}
