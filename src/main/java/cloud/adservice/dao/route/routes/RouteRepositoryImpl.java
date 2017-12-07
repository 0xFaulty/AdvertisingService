package cloud.adservice.dao.route.routes;

import cloud.adservice.model.route.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RouteRepositoryImpl implements RouteRepositoryCustom {

    private static final Logger logger = LoggerFactory.getLogger(RouteRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Route item) {
        entityManager.persist(item);
        logger.info("Successfully saved. Details: " + item);
    }

    @Override
    public void update(Route item) {
        entityManager.merge(item);
        logger.info("Successfully update. Details: " + item);
    }

    @Override
    public void remove(long id) {
        Route item = entityManager.find(Route.class, id);

        if (item != null) {
            entityManager.remove(item);
        }
        logger.info("Successfully removed. Details: " + item);
    }

    @Override
    public Route getById(long id) {
        Route item = entityManager.find(Route.class, id);
        logger.info("Successfully loaded. Details: " + item);

        return item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Route> list() {
        List<Route> itemList = entityManager.createQuery("from Route").getResultList();
        logger.info(this.getClass().getName() + " item list loaded. Size: " + itemList.size());
        return itemList;
    }

}
