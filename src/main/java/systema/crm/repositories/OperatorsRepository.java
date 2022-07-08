package systema.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import systema.crm.entities.Operators;

@Repository
@Transactional
public interface OperatorsRepository extends JpaRepository<Operators, Long> {
}
