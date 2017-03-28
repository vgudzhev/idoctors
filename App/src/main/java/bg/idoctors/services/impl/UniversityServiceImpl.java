package bg.idoctors.services.impl;

import bg.idoctors.domain.University;
import bg.idoctors.repositories.UniversityRepository;
import bg.idoctors.services.UniversityService;
import org.springframework.stereotype.Service;

@Service
public class UniversityServiceImpl implements UniversityService {
	private UniversityRepository repository;

	@Override
	public Iterable<University> listAllUniversities() {
		return repository.findAll();
	}

	@Override
	public University getUniversityById(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public University saveUniversity(University university) {
		return repository.save(university);
	}
}
