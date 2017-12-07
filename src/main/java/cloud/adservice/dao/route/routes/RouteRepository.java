package cloud.adservice.dao.route.routes;

import cloud.adservice.model.route.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long>, RouteRepositoryCustom {
}
