package cloud.adservice.dao.infrastructure.shop;

import cloud.adservice.model.infrastructure.Shop;

import java.util.List;

public interface ShopRepositoryCustom {

    void add(Shop item);

    void update(Shop item);

    void remove(long id);

    Shop getById(long id);

    List<Shop> list();

    List<String> getCategoryList();

}
