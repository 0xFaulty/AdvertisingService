package cloud.adservice.service.operations;

import cloud.adservice.model.infrastructure.Metro;
import cloud.adservice.model.infrastructure.Shop;
import cloud.adservice.model.route.WeightRoute;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Pareto {

    private List<Shop> shopList;

    private List<WeightRoute> bestRoutes;

    private List<Metro> metroList;

    private List<Pair<WeightRoute, Integer>> pairList = new ArrayList<>();

    public Pareto(List<Shop> shopList, List<WeightRoute> bestRoutes, List<Metro> metroList) {
        this.shopList = shopList;
        bestRoutes.sort((e, e2) -> (int) (e.getWeight() - e2.getWeight()));
        this.bestRoutes = bestRoutes;
        this.metroList = metroList;
    }

    public List<Pair<WeightRoute, Integer>> getPareto() {
        for (WeightRoute route : bestRoutes) {
            int metroCount = 0;
            for (Metro metro : metroList) {
                double meters = Coordinates.gps2m(route.getLat(), route.getLon(), metro.getLat(), metro.getLon());
                if (meters < 1000) metroCount++;
            }
            int shopCount = 0;
            for (Shop shop : shopList) {
                double meters = Coordinates.gps2m(route.getLat(), route.getLon(), shop.getLat(), shop.getLon());
                if (meters < 1000) shopCount++;
            }
            pairList.add(new Pair<>(route, metroCount + shopCount));
        }
        Pair<WeightRoute, Integer> pair = pairList.get(pairList.size() - 1);
        for (int j = pairList.size() - 2; j > 0; j--) {
            Pair<WeightRoute, Integer> pair2 = pairList.get(j);
            if ((pair.getValue() > pair2.getValue() && pair.getKey().getWeight() > pair2.getKey().getWeight()) ||
                    ((int) pair.getValue() == pair2.getValue() && pair.getKey().getWeight() > pair2.getKey().getWeight()) ||
                    (pair.getValue() > pair2.getValue() && pair.getKey().getWeight() == pair2.getKey().getWeight())) {
                pairList.remove(j);

            }
        }

        return pairList;
    }

}
