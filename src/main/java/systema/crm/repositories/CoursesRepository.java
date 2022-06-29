package systema.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import systema.crm.entities.Courses;

@Repository
@Transactional
public interface CoursesRepository extends JpaRepository<Courses, Long> {
}
