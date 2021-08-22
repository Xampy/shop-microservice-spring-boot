package com.xampydrivesell.userShopService.domain.shop;

import com.xampydrivesell.userShopService.domain.dto.request.GetAllShopRequest;
import com.xampydrivesell.userShopService.domain.dto.response.shop.GetAllShopResponse;
import com.xampydrivesell.userShopService.domain.port.primary.service.ShopServiceInterface;
import com.xampydrivesell.userShopService.domain.port.secondary.repository.ShopRepositoryInterface;
import com.xampydrivesell.userShopService.domain.useCase.shop.GetAllShopsUseCase;
import com.xampydrivesell.userShopService.infrastructure.adapter.primary.service.ShopService;
import com.xampydrivesell.userShopService.infrastructure.adapter.secondary.repository.InMemoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class GetAllShopTests {

    @Mock private ShopServiceInterface service;

    @Test
    @DisplayName("Get user shops list")
    void itShouldCallGetAllFromService(){
        GetAllShopRequest request = new GetAllShopRequest();
        GetAllShopsUseCase useCase = new GetAllShopsUseCase();

        useCase.execute(request, null, service);

        verify(service).getAllShop();

    }
}
