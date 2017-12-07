package cloud.adservice.dao.population.people;

import cloud.adservice.model.population.People;

import java.util.List;

public interface PeopleRepositoryCustom {

    void add(People item);

    void update(People item);

    void remove(long id);

    People getById(long id);

    List<People> list();

}
