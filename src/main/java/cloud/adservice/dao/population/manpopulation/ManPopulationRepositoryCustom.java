package cloud.adservice.dao.population.manpopulation;

import cloud.adservice.model.population.ManPopulation;

import java.util.List;

public interface ManPopulationRepositoryCustom {

    void add(ManPopulation item);

    void update(ManPopulation item);

    void remove(long id);

    ManPopulation getById(long id);

    List<ManPopulation> list();

}
