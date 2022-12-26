package sportfacility.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sportfacility.data.entities.Timetable;

public interface TimetableRepository extends JpaRepository<Timetable, String>{

}
