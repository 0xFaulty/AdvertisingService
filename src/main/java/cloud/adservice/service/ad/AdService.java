package cloud.adservice.service.ad;

import cloud.adservice.model.infrastructure.Metro;
import cloud.adservice.model.infrastructure.Shop;
import cloud.adservice.model.mappoint.WeightMapPoint;
import cloud.adservice.model.population.House;
import cloud.adservice.model.population.People;
import cloud.adservice.model.route.WeightRoute;

import java.util.List;

public interface AdService {

    List<Metro> getMetro();

    List<People> getPeople();

    List<WeightRoute> getTransport();

    List<Shop> getShops();

    List<House> getHouses();

    List<Shop> getShopsByCategory(String category);

    List<WeightMapPoint> getBestAdPoint(String adCategory);

}
