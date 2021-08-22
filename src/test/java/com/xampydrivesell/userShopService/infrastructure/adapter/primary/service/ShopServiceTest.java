package com.xampydrivesell.userShopService.infrastructure.adapter.primary.service;

import com.xampydrivesell.userShopService.domain.entity.Shop;
import com.xampydrivesell.userShopService.domain.port.secondary.repository.ShopRepositoryInterface;
import com.xampydrivesell.userShopService.domain.share.exception.ShopNameAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ShopServiceTest {

    @Mock private ShopRepositoryInterface repository;
    private ShopService shopService;

    @BeforeEach
    void setUp() {
        this.shopService = new ShopService(repository);
    }

    //[START] Service add method
    @Test
    void itShouldWhenAddCallSaveFromRepository() {
        //given
        Shop shop = new Shop("shop");

        //when
        assertDoesNotThrow(() -> shopService.add(shop));

        //then
        ArgumentCaptor<Shop> shopArgumentCaptor =
                ArgumentCaptor.forClass(Shop.class);

        verify(repository).save(shopArgumentCaptor.capture());

        Shop capturedShop = shopArgumentCaptor.getValue();
        assertEquals(capturedShop, shop);
    }

    @Test
    void itShouldThrowWhenAddCalledAndNameIsTaken() {
        //given
        Shop shop = new Shop("shop");
        given(repository.selectExistsByName(shop.getName())).willReturn(true);

        //when
        //then
        assertThrows(ShopNameAlreadyExistsException.class, () -> shopService.add(shop));

        verify(repository, never()).save(shop);

    }
    //[END] Service add method

    @Test
    void itShouldCallMethodByNameWhenNameIsProvided() {
        //given
        //when
        Shop shop = shopService.getShopByName(anyString());

        //then
        verify(repository).getByName(anyString());
    }

    @Test
    void itShouldGetAllShop() {
        //given
        //when
        shopService.getAllShop();

        //then
        verify(repository).findAll();
    }
}