package bg.idoctors.repositories;

import org.springframework.data.repository.CrudRepository;

import bg.idoctors.domain.Hospital;

public interface HospitalRepository extends CrudRepository<Hospital, Integer> {
}
