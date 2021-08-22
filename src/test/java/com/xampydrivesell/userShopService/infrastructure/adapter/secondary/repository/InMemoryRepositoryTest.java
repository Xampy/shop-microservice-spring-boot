package com.xampydrivesell.userShopService.infrastructure.adapter.secondary.repository;

import com.xampydrivesell.userShopService.domain.entity.Shop;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryRepositoryTest {

    private InMemoryRepository repository;

    @BeforeEach
    void setUp(){
        repository = new InMemoryRepository();
    }

    @AfterEach
    void tearDown(){
        this.repository.deleteAll();
    }

    @Test
    void itShouldCheckWhenShopNameExists() {
        //given
        String shopName = "shop 1";
        Shop shop = new Shop(shopName);
        repository.save(shop);

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