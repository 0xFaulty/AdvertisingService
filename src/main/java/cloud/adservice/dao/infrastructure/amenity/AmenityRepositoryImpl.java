package cloud.adservice.dao.infrastructure.amenity;

import cloud.adservice.model.infrastructure.Amenity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AmenityRepositoryImpl implements AmenityRepositoryCustom {

    private static final Logger logger = LoggerFactory.getLogger(AmenityRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Amenity item) {
        entityManager.persist(item);
        logger.info("Successfully saved. Details: " + item);
    }

    @Override
    public void update(Amenity item) {
        entityManager.merge(item);
        logger.info("Successfully update. Details: " + item);
    }

    @Override
    public void remove(long id) {
        Amenity item = entityManager.find(Amenity.class, id);

        if (item != null) {
            entityManager.remove(item);
        }
        logger.info("Successfully removed. Details: " + item);
    }

    @Override
    public Amenity getById(long id) {
        Amenity item = entityManager.find(Amenity.class, id);
        logger.info("Successfully loaded. Details: " + item);

        return item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Amenity> list() {
        List<Amenity> itemList = entityManager.createQuery("from Amenity").getResultList();
        logger.info(this.getClass().getName() + " item list loaded. Size: " + itemList.size());
        return itemList;
    }

}
