package cloud.adservice.dao.infrastructure.metro;

import cloud.adservice.model.infrastructure.Metro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetroRepository extends JpaRepository<Metro, Long>, MetroRepositoryCustom {
}
