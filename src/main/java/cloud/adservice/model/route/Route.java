package cloud.adservice.model.route;

import cloud.adservice.model.mappoint.MapPoint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "transport_points")
@AllArgsConstructor
@NoArgsConstructor
public @Data
class Route implements MapPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "route_id")
    private int route_id;
//
//    @Column(name = "route_short_name")
//    private String route_short_name;
//
//    @Column(name = "route_long_name")
//    private String route_long_name;
//
//    @Column(name = "transport_type")
//    private String transport_type;
//
//    @Column(name = "direction")
//    private String direction;
//
//    @Column(name = "stop_id")
//    private String stop_id;
//
//    @Column(name = "next_stop")
//    private String next_stop;
//
//    @Column(name = "stop_distance")
//    private String stop_distance;
//
//    @Column(name = "stop_name")
//    private String stop_name;

    @Column(name = "stop_lat")
    private double lat;

    @Column(name = "stop_lon")
    private double lon;

}
