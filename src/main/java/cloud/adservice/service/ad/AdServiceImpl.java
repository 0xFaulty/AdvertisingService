package cloud.adservice.service.ad;

import cloud.adservice.dao.infrastructure.amenity.AmenityRepository;
import cloud.adservice.dao.infrastructure.metro.MetroRepository;
import cloud.adservice.dao.infrastructure.shop.ShopRepository;
import cloud.adservice.dao.population.house.HouseRepository;
import cloud.adservice.dao.population.manpopulation.ManPopulationRepository;
import cloud.adservice.dao.population.people.PeopleRepository;
import cloud.adservice.dao.population.womanpopulation.WomanPopulationRepository;
import cloud.adservice.dao.route.routes.RouteRepository;
import cloud.adservice.dao.route.weightroutes.WeightRouteRepository;
import cloud.adservice.model.mappoint.AreaPoint;
import cloud.adservice.model.infrastructure.Metro;
import cloud.adservice.model.infrastructure.Shop;
import cloud.adservice.model.population.House;
import cloud.adservice.model.population.People;
import cloud.adservice.model.route.WeightRoute;
import cloud.adservice.service.operations.Pareto;
import cloud.adservice.model.mappoint.WeightMapPoint;
import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdServiceImpl implements AdService {

    final static Logger LOG = LoggerFactory.getLogger(AdServiceImpl.class);

    @Autowired
    private AmenityRepository amenityRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ManPopulationRepository manPopulationRepository;

    @Autowired
    private WomanPopulationRepository womanPopulationRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private WeightRouteRepository weightRouteRepository;

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private MetroRepository metroRepository;

    @Override
    public List<Metro> getMetro() {
        return metroRepository.list();
    }

    @Override
    public List<People> getPeople() {
        return peopleRepository.list();
    }

    @Override
    public List<WeightRoute> getTransport() {
        return deleteWeightLessThan(weightRouteRepository.list(), -1);
    }

    @Override
    public List<Shop> getShops() {
        return shopRepository.list();
    }

    @Override
    public List<House> getHouses() {
        return houseRepository.list();
    }

    @Override
    public List<Shop> getShopsByCategory(String category) {
        List<Shop> shopList = shopRepository.list();
        List<Shop> result = new ArrayList<>();

        for (Shop shop : shopList)
            if (shop.getCategory().equals(category)) result.add(shop);

        return result;
    }

    @Override
    public List<WeightMapPoint> getBestAdPoint(String adCategory) {
        List<Shop> shopList = getShopsByCategory(adCategory);
        // FIXME: 05.12.2017 Добавить проверку на существование категории, т.к. всё равно будет считать результат.
        List<WeightRoute> bestRoutes = deleteWeightLessThan(weightRouteRepository.list(), 30);
        List<Metro> metroList = getMetro();

        List<Pair<WeightRoute, Integer>> list = new Pareto(shopList, bestRoutes, metroList).getPareto();

        List<WeightMapPoint> areaPointList = new ArrayList<>();
        for (Pair<WeightRoute, Integer> pair : list)
            areaPointList.add(new AreaPoint((pair.getKey().getWeight() + pair.getValue()), pair.getKey().getLat(), pair.getKey().getLon()));

        return areaPointList;
    }

    /**
     * Метод удаляет точки весом меньше указанного.
     *
     * @param list    - список точек с весом.
     * @param limiter - ограничитель.
     * @param <T>     - Точка с весом
     * @return - прореженный список, если ограничитель меньше нуля, то изначальный список.
     */
    private <T extends WeightMapPoint> List<T> deleteWeightLessThan(List<T> list, int limiter) {
        if (limiter >= 0) {
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i).getWeight() < limiter)
                    list.remove(i);
            }
        }

        return list;
    }

}
