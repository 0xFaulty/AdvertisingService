package cloud.adservice.dao.population.people;

import cloud.adservice.model.population.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Long>, PeopleRepositoryCustom {
}
