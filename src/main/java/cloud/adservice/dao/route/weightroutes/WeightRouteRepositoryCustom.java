package cloud.adservice.dao.route.weightroutes;

import cloud.adservice.model.route.WeightRoute;

import java.util.List;

public interface WeightRouteRepositoryCustom {

    void add(WeightRoute item);

    void update(WeightRoute item);

    void remove(long id);

    WeightRoute getById(long id);

    List<WeightRoute> list();

}
