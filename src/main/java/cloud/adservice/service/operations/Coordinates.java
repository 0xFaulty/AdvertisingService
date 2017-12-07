package cloud.adservice.service.operations;

import cloud.adservice.model.mappoint.AreaPoint;
import cloud.adservice.model.mappoint.MapPoint;
import cloud.adservice.model.mappoint.WeightMapPoint;

import java.util.ArrayList;
import java.util.List;

public class Coordinates {

    public static double gps2m(double lat_a, double lng_a, double lat_b, double lng_b) {
        double pk = 180 / 3.14169;

        double a1 = lat_a / pk;
        double a2 = lng_a / pk;
        double b1 = lat_b / pk;
        double b2 = lng_b / pk;

        double t1 = Math.cos(a1) * Math.cos(a2) * Math.cos(b1) * Math.cos(b2);
        double t2 = Math.cos(a1) * Math.sin(a2) * Math.cos(b1) * Math.sin(b2);
        double t3 = Math.sin(a1) * Math.sin(b1);
        double tt = Math.acos(t1 + t2 + t3);

        return 6366000 * tt;
    }

    // FIXME: 05.12.2017 При увеличении метров (metersRegion) выдаёт больше результатов и наоборот.

    /**
     * Кластеризует объекты объединяя с другими в заданной области.
     *
     * @param list         - входной список.
     * @param metersRegion - область объединения.
     * @return - список собранных точек.
     */
    public static List<WeightMapPoint> cluster(List<MapPoint> list, double metersRegion) {
        List<WeightMapPoint> resultList = new ArrayList<>();

        if (!list.isEmpty()) {
            long count;
            for (int i = 0; i < list.size() - 1; i++) {
                count = 0;
                MapPoint point1 = list.get(i);
                if (point1 != null) {
                    for (int j = i + 1; j < list.size(); j++) {
                        MapPoint point2 = list.get(j);
                        if (point2 != null) {
                            if (gps2m(point1.getLat(), point1.getLon(), point2.getLat(), point2.getLon()) < metersRegion) {
                                count++;
                                list.set(j, null);
                            }
                        }
                    }
                }
                if (count > 0) {
                    resultList.add(new AreaPoint(count, point1.getLat(), point1.getLon()));
                    list.set(i, null);
                }
            }
        }

        return resultList;
    }

}
