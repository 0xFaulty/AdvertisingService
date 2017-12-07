package cloud.adservice.dao.infrastructure.shop;

import cloud.adservice.model.infrastructure.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long>, ShopRepositoryCustom {
}
