package com.xampydrivesell.userShopService.infrastructure.adapter.secondary.repository;

import com.xampydrivesell.userShopService.domain.entity.Shop;
import com.xampydrivesell.userShopService.domain.port.secondary.repository.ShopRepositoryInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopDatabaseRepository extends JpaRepository<Shop, Long>, ShopRepositoryInterface  {
    @Override
    @Query("" +
            "SELECT CASE WHEN COUNT(s) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Shop s " +
            "WHERE s.name = ?1"
    )
    boolean selectExistsByName(String name);
}
