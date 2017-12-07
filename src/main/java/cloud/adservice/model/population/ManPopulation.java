package cloud.adservice.model.population;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "man_population")
@AllArgsConstructor
@NoArgsConstructor
public @Data
class ManPopulation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "area_name")
    private long area_name;

    @Column(name = "all_count")
    private long all_count;

    @Column(name = "young_count")
    private long young_count;

    @Column(name = "average_count")
    private long average_count;

    @Column(name = "old_count")
    private long old_count;

}
