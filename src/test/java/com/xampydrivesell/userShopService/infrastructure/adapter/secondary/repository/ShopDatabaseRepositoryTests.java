package com.xampydrivesell.userShopService.infrastructure.adapter.secondary.repository;

import com.xampydrivesell.userShopService.domain.entity.Shop;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.JpaRepository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class ShopDatabaseRepositoryTests {

    @Autowired
    private ShopDatabaseRepository repository;



    @AfterEach
    void tearDown(){
        this.repository.deleteAll();
    }

    @Test
    void itShouldCheckWhenShopNameExists() {
        //given
        String shopName = "shop 1";
        Shop shop = new Shop(shopName);
        ((JpaRepository<Shop, Long>) repository).save(shop);

        //When
        boolean expected = repository.selectExistsByName(shopName);

        //then
        assertTrue(expected);
    }

    @Test
    void itShouldCheckWhenShopNameDoesNotExists() {
        //given
        String shopName = "shop 1";
        Shop shop = new Shop(shopName);

        //When
        boolean expected = repository.selectExistsByName(shopName);

        //then
        assertFalse(expected);
    }
}
