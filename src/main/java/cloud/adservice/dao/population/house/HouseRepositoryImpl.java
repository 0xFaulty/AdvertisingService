package cloud.adservice.dao.population.house;

import cloud.adservice.model.population.House;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HouseRepositoryImpl implements HouseRepositoryCustom {

    private static final Logger logger = LoggerFactory.getLogger(HouseRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(House item) {
        entityManager.persist(item);
        logger.info("Successfully saved. Details: " + item);
    }

    @Override
    public void update(House item) {
        entityManager.merge(item);
        logger.info("Successfully update. Details: " + item);
    }

    @Override
    public void remove(long id) {
        House item = entityManager.find(House.class, id);

        if (item != null) {
            entityManager.remove(item);
        }
        logger.info("Successfully removed. Details: " + item);
    }

    @Override
    public House getById(long id) {
        House item = entityManager.find(House.class, id);
        logger.info("Successfully loaded. Details: " + item);

        return item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<House> list() {
        List<House> itemList = entityManager.createQuery("from House").getResultList();
        logger.info(this.getClass().getName() + " item list loaded. Size: " + itemList.size());
        return itemList;
    }

}
