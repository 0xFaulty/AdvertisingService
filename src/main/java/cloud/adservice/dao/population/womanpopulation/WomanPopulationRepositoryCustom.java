package cloud.adservice.dao.population.womanpopulation;

import cloud.adservice.model.population.WomanPopulation;

import java.util.List;

public interface WomanPopulationRepositoryCustom {

    void add(WomanPopulation item);

    void update(WomanPopulation item);

    void remove(long id);

    WomanPopulation getById(long id);

    List<WomanPopulation> list();

}
