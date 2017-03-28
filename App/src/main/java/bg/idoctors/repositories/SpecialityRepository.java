package bg.idoctors.repositories;

import org.springframework.data.repository.CrudRepository;

import bg.idoctors.domain.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Integer> {
}
