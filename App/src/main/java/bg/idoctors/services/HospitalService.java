package bg.idoctors.services;

import bg.idoctors.domain.Hospital;

public interface HospitalService {
	
	Iterable<Hospital> listAllHospitals();

	Hospital getHospitalById(Integer id);

	Hospital saveHospital(Hospital hospital);
}
