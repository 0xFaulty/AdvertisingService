package cloud.adservice.dao.population.womanpopulation;

import cloud.adservice.model.population.WomanPopulation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class WomanPopulationRepositoryImpl implements WomanPopulationRepositoryCustom {

    private static final Logger logger = LoggerFactory.getLogger(WomanPopulationRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(WomanPopulation item) {
        entityManager.persist(item);
        logger.info("Successfully saved. Details: " + item);
    }

    @Override
    public void update(WomanPopulation item) {
        entityManager.merge(item);
        logger.info("Successfully update. Details: " + item);
    }

    @Override
    public void remove(long id) {
        WomanPopulation item = entityManager.find(WomanPopulation.class, id);

        if (item != null) {
            entityManager.remove(item);
        }
        logger.info("Successfully removed. Details: " + item);
    }

    @Override
    public WomanPopulation getById(long id) {
        WomanPopulation item = entityManager.find(WomanPopulation.class, id);
        logger.info("Successfully loaded. Details: " + item);

        return item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<WomanPopulation> list() {
        List<WomanPopulation> itemList = entityManager.createQuery("from WomanPopulation").getResultList();
        logger.info(this.getClass().getName() + " item list loaded. Size: " + itemList.size());
        return itemList;
    }

}
