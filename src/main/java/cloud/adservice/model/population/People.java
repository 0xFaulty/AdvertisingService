package cloud.adservice.model.population;

import cloud.adservice.model.mappoint.MapPoint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "people")
@AllArgsConstructor
@NoArgsConstructor
public @Data
class People implements MapPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "count")
    private int count;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lon")
    private double lon;

}
