package cloud.adservice.dao.population.womanpopulation;

import cloud.adservice.model.population.WomanPopulation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WomanPopulationRepository extends JpaRepository<WomanPopulation, Long>, WomanPopulationRepositoryCustom {
}
