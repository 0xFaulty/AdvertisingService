package cloud.adservice.dao.route.weightroutes;

import cloud.adservice.model.route.WeightRoute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightRouteRepository extends JpaRepository<WeightRoute, Long>, WeightRouteRepositoryCustom {
}
