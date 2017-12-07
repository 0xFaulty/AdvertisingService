package cloud.adservice.model.route;

import cloud.adservice.model.mappoint.WeightMapPoint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "weight_routes")
@AllArgsConstructor
@NoArgsConstructor
public @Data
class WeightRoute implements WeightMapPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "p_weight")
    private long weight;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lon")
    private double lon;

}
