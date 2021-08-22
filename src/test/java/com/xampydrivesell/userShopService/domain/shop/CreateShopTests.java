package com.xampydrivesell.userShopService.domain.shop;

import com.xampydrivesell.userShopService.domain.dto.request.CreateShopRequest;
import com.xampydrivesell.userShopService.domain.dto.response.shop.CreateShopResponse;
import com.xampydrivesell.userShopService.domain.port.primary.service.ShopServiceInterface;
import com.xampydrivesell.userShopService.domain.share.exception.ShopNameAlreadyExistsException;
import com.xampydrivesell.userShopService.domain.useCase.shop.CreateShopUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
public class CreateShopTests {

    @Mock
    private ShopServiceInterface service;


    @Test
    public void itShouldNotReturnNullResponseWhenNoException(){
        String shopName = "Test";
        CreateShopRequest request = new CreateShopRequest(shopName);
        CreateShopUseCase useCase = new CreateShopUseCase();

        CreateShopResponse response = useCase.execute(request, null, this.service);
        assertNotNull(response);
        assertNotNull(response.getShop());
        assertEquals(shopName, response.getShop().getName());
    }

    @Test
    public void itShouldNotReturnNullResponseWhenExceptionAndContentMustBeNull() throws Exception {
        //given
        CreateShopRequest request = new CreateShopRequest("test");
        CreateShopUseCase useCase = new CreateShopUseCase();

        //then
        doThrow(ShopNameAlreadyExistsException.class)
                .when(service)
                        .add(any());
        //when
        CreateShopResponse response = useCase.execute(request, null, service);

        assertNotNull(response);
        assertNull(response.getShop());
    }
}
