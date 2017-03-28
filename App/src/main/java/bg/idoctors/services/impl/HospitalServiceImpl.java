package bg.idoctors.services.impl;

import bg.idoctors.domain.Doctor;
import bg.idoctors.domain.Hospital;
import bg.idoctors.repositories.DoctorRepository;
import bg.idoctors.repositories.HospitalRepository;
import bg.idoctors.services.DoctorService;
import bg.idoctors.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImpl implements HospitalService {
	@Autowired
	private HospitalRepository repository;

	@Override
	public Iterable<Hospital> listAllHospitals() {
		return repository.findAll();
	}

	@Override
	public Hospital getHospitalById(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public Hospital saveHospital(Hospital hospital) {
		return repository.save(hospital);
	}
}
