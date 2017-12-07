package cloud.adservice.dao.population.manpopulation;

import cloud.adservice.model.population.ManPopulation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManPopulationRepository extends JpaRepository<ManPopulation, Long>, ManPopulationRepositoryCustom {
}
