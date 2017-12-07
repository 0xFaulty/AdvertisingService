package cloud.adservice.model.infrastructure;

import cloud.adservice.model.mappoint.MapPoint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "shops")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public @Data
class Shop implements MapPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "category")
    private String category;

    @Column(name = "name")
    private String name;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lon")
    private double lon;

}
