package cloud.adservice.dao.infrastructure.shop;

import cloud.adservice.model.infrastructure.Shop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ShopRepositoryImpl implements ShopRepositoryCustom {

    private static final Logger logger = LoggerFactory.getLogger(ShopRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Shop item) {
        entityManager.persist(item);
        logger.info("Successfully saved. Details: " + item);
    }

    @Override
    public void update(Shop item) {
        entityManager.merge(item);
        logger.info("Successfully update. Details: " + item);
    }

    @Override
    public void remove(long id) {
        Shop item = entityManager.find(Shop.class, id);

        if (item != null) {
            entityManager.remove(item);
        }
        logger.info("Successfully removed. Details: " + item);
    }

    @Override
    public Shop getById(long id) {
        Shop item = entityManager.find(Shop.class, id);
        logger.info("Successfully loaded. Details: " + item);

        return item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Shop> list() {
        List<Shop> itemList = entityManager.createQuery("from Shop").getResultList();
        logger.info(this.getClass().getName() + " item list loaded. Size: " + itemList.size());
        return itemList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> getCategoryList() {
        return entityManager.createQuery("select category from Shop group by category").getResultList();
    }

}
