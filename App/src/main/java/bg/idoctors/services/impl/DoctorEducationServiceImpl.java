package bg.idoctors.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.idoctors.domain.Doctor;
import bg.idoctors.domain.DoctorEducation;
import bg.idoctors.repositories.DoctorEducationRepository;
import bg.idoctors.repositories.DoctorRepository;
import bg.idoctors.services.DoctorEducationService;
import bg.idoctors.services.DoctorService;

@Service
public class DoctorEducationServiceImpl implements DoctorEducationService {

	@Autowired
	private DoctorEducationRepository repository;
	
	@Override
	public Iterable<DoctorEducation> listAllniversities() {
		return repository.findAll();
	}

	@Override
	public DoctorEducation getDoctorEducationByDoctorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DoctorEducation saveDoctor(DoctorEducation doctorEducation) {
		// TODO Auto-generated method stub
		return null;
	}


}
