package cloud.adservice.dao.population.house;

import cloud.adservice.model.population.House;

import java.util.List;

public interface HouseRepositoryCustom {

    void add(House item);

    void update(House item);

    void remove(long id);

    House getById(long id);

    List<House> list();

}
