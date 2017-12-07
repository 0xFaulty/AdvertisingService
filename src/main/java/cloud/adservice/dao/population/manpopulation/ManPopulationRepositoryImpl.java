package cloud.adservice.dao.population.manpopulation;

import cloud.adservice.model.population.ManPopulation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ManPopulationRepositoryImpl implements ManPopulationRepositoryCustom {

    private static final Logger logger = LoggerFactory.getLogger(ManPopulationRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(ManPopulation item) {
        entityManager.persist(item);
        logger.info("Successfully saved. Details: " + item);
    }

    @Override
    public void update(ManPopulation item) {
        entityManager.merge(item);
        logger.info("Successfully update. Details: " + item);
    }

    @Override
    public void remove(long id) {
        ManPopulation item = entityManager.find(ManPopulation.class, id);

        if (item != null) {
            entityManager.remove(item);
        }
        logger.info("Successfully removed. Details: " + item);
    }

    @Override
    public ManPopulation getById(long id) {
        ManPopulation item = entityManager.find(ManPopulation.class, id);
        logger.info("Successfully loaded. Details: " + item);

        return item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ManPopulation> list() {
        List<ManPopulation> itemList = entityManager.createQuery("from ManPopulation").getResultList();
        logger.info(this.getClass().getName() + " item list loaded. Size: " + itemList.size());
        return itemList;
    }

}
