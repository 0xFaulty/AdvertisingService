package cloud.adservice.dao.infrastructure.amenity;

import cloud.adservice.model.infrastructure.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenityRepository extends JpaRepository<Amenity, Long>, AmenityRepositoryCustom {
}
