package systema.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import systema.crm.entities.ApplicationRequest;

import java.util.List;

@Repository
@Transactional
public interface ApplicationRequestRepository extends JpaRepository<ApplicationRequest, Long> {
    @Query("SELECT a FROM ApplicationRequest as a ORDER BY a.handled ASC ")
    List<ApplicationRequest> getAll();

    List<ApplicationRequest> findAllByHandledIsFalse();

    List<ApplicationRequest> findAllByHandledIsTrue();
}