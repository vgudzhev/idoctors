package bg.idoctors.repositories;

import org.springframework.data.repository.CrudRepository;

import bg.idoctors.domain.DoctorWorkSchedule;

public interface DoctorWorkScheduleRepository extends CrudRepository<DoctorWorkSchedule, Integer> {
}
