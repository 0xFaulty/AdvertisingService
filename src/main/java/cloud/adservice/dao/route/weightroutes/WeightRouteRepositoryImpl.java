package cloud.adservice.dao.route.weightroutes;

import cloud.adservice.model.route.WeightRoute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class WeightRouteRepositoryImpl implements WeightRouteRepositoryCustom {

    private static final Logger logger = LoggerFactory.getLogger(WeightRouteRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(WeightRoute item) {
        entityManager.persist(item);
        logger.info("Successfully saved. Details: " + item);
    }

    @Override
    public void update(WeightRoute item) {
        entityManager.merge(item);
        logger.info("Successfully update. Details: " + item);
    }

    @Override
    public void remove(long id) {
        WeightRoute item = entityManager.find(WeightRoute.class, id);

        if (item != null) {
            entityManager.remove(item);
        }
        logger.info("Successfully removed. Details: " + item);
    }

    @Override
    public WeightRoute getById(long id) {
        WeightRoute item = entityManager.find(WeightRoute.class, id);
        logger.info("Successfully loaded. Details: " + item);

        return item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<WeightRoute> list() {
        List<WeightRoute> itemList = entityManager.createQuery("from WeightRoute").getResultList();
        logger.info(this.getClass().getName() + " item list loaded. Size: " + itemList.size());
        return itemList;
    }

}
