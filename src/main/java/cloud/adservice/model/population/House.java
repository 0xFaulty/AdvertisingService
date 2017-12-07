package cloud.adservice.model.population;

import cloud.adservice.model.mappoint.MapPoint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "houses")
@AllArgsConstructor
@NoArgsConstructor
public @Data
class House implements MapPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "area_name")
    private long area_name;

    @Column(name = "count_population")
    private long count_population;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lon")
    private double lon;

}
