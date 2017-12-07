package cloud.adservice.dao.population.house;

import cloud.adservice.model.population.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long>, HouseRepositoryCustom {
}
