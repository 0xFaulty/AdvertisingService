package cloud.adservice.dao.population.people;

import cloud.adservice.model.population.People;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PeopleRepositoryImpl implements PeopleRepositoryCustom {

    private static final Logger logger = LoggerFactory.getLogger(PeopleRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(People item) {
        entityManager.persist(item);
        logger.info("Successfully saved. Details: " + item);
    }

    @Override
    public void update(People item) {
        entityManager.merge(item);
        logger.info("Successfully update. Details: " + item);
    }

    @Override
    public void remove(long id) {
        People item = entityManager.find(People.class, id);

        if (item != null) {
            entityManager.remove(item);
        }
        logger.info("Successfully removed. Details: " + item);
    }

    @Override
    public People getById(long id) {
        People item = entityManager.find(People.class, id);
        logger.info("Successfully loaded. Details: " + item);

        return item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<People> list() {
        List<People> itemList = entityManager.createQuery("from People").getResultList();
        logger.info(this.getClass().getName() + " item list loaded. Size: " + itemList.size());
        return itemList;
    }

}
