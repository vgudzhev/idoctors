package bg.idoctors.repositories;

import org.springframework.data.repository.CrudRepository;

import bg.idoctors.domain.WorkTime;

public interface WorkTimeRepository extends CrudRepository<WorkTime, Integer> {
}
