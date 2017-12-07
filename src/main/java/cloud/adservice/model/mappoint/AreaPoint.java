package cloud.adservice.model.mappoint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data
class AreaPoint implements WeightMapPoint {

    private long weight;

    private double lat;

    private double lon;

}
