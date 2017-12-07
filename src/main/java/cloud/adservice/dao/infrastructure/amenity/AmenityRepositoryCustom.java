package cloud.adservice.dao.infrastructure.amenity;

import cloud.adservice.model.infrastructure.Amenity;

import java.util.List;

public interface AmenityRepositoryCustom {

    void add(Amenity item);

    void update(Amenity item);

    void remove(long id);

    Amenity getById(long id);

    List<Amenity> list();

}
