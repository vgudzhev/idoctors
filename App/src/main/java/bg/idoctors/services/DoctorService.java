package bg.idoctors.services;

import bg.idoctors.domain.Doctor;

public interface DoctorService {
	
	Iterable<Doctor> listAllDoctors();

	Doctor getDoctorById(Integer id);

	Doctor saveDoctor(Doctor product);
}
