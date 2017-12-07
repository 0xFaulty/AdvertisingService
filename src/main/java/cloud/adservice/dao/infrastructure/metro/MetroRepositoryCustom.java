package cloud.adservice.dao.infrastructure.metro;

import cloud.adservice.model.infrastructure.Metro;

import java.util.List;

public interface MetroRepositoryCustom {

    void add(Metro item);

    void update(Metro item);

    void remove(long id);

    Metro getById(long id);

    List<Metro> list();

}
