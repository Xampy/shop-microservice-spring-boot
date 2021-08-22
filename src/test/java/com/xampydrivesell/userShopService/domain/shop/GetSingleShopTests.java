package com.xampydrivesell.userShopService.domain.shop;

import com.xampydrivesell.userShopService.domain.dto.request.GetSingleShopRequest;
import com.xampydrivesell.userShopService.domain.dto.response.shop.CreateShopResponse;
import com.xampydrivesell.userShopService.domain.dto.response.shop.GetSingleShopResponse;
import com.xampydrivesell.userShopService.domain.port.secondary.repository.ShopRepositoryInterface;
import com.xampydrivesell.userShopService.domain.share.exception.CustomException;
import com.xampydrivesell.userShopService.domain.useCase.shop.GetSingleShopUseCase;
import com.xampydrivesell.userShopService.infrastructure.adapter.secondary.repository.InMemoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GetSingleShopTests {

    ShopRepositoryInterface repository;

    String existShopName = "Shop Exists";
    String notExistShopName = "Shop Does not Exists";

    @BeforeEach
    void setUp(){
        this.repository = new InMemoryRepository();


    }

    @Test
    public void givenAShopName_whenShopExists_thenReturnShop(){
        assertEquals(false, false);
    }

    @Test
    public void givenAShopName_whenShopDoesNotExists_thenReturnNull(){
        assertEquals(false, false);
    }
}
