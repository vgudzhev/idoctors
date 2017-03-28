package bg.idoctors.services;

import bg.idoctors.domain.University;

public interface UniversityService {
	
	Iterable<University> listAllUniversities();

	University getUniversityById(Integer id);

	University saveUniversity(University university);
}
