package cloud.adservice.dao.route.routes;

import cloud.adservice.model.route.Route;

import java.util.List;

public interface RouteRepositoryCustom {

    void add(Route item);

    void update(Route item);

    void remove(long id);

    Route getById(long id);

    List<Route> list();

}
