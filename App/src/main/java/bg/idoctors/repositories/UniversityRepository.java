package bg.idoctors.repositories;

import org.springframework.data.repository.CrudRepository;

import bg.idoctors.domain.University;

public interface UniversityRepository extends CrudRepository<University, Integer> {
}
