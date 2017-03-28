package bg.idoctors.repositories;

import org.springframework.data.repository.CrudRepository;

import bg.idoctors.domain.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
}
