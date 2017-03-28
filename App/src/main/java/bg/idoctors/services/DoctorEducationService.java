package bg.idoctors.services;

import bg.idoctors.domain.Doctor;
import bg.idoctors.domain.DoctorEducation;

public interface DoctorEducationService {
	
	Iterable<DoctorEducation> listAllniversities();

	DoctorEducation getDoctorEducationByDoctorId(Integer id);

	DoctorEducation saveDoctor(DoctorEducation doctorEducation);
}
