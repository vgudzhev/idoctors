package bg.idoctors.repositories;

import org.springframework.data.repository.CrudRepository;
import bg.idoctors.domain.Doctor;
import bg.idoctors.domain.DoctorEducation;
import bg.idoctors.domain.DoctorWorkSchedule;

public interface DoctorEducationRepository extends CrudRepository<DoctorEducation, Integer> {
}
