package com.xampydrivesell.userShopService.domain.useCase.shop;

import com.xampydrivesell.userShopService.domain.dto.request.CreateShopRequest;
import com.xampydrivesell.userShopService.domain.dto.response.shop.CreateShopResponse;
import com.xampydrivesell.userShopService.domain.entity.Shop;
import com.xampydrivesell.userShopService.domain.port.primary.service.ShopServiceInterface;
import com.xampydrivesell.userShopService.domain.port.secondary.repository.ShopRepositoryInterface;
import com.xampydrivesell.userShopService.domain.share.exception.ShopNameAlreadyExistsException;
import com.xampydrivesell.userShopService.domain.useCase.AbstractUseCase;
import org.springframework.lang.Nullable;

public class CreateShopUseCase extends AbstractUseCase<CreateShopRequest, CreateShopResponse> {

    private ShopServiceInterface service;

    @Override
    public CreateShopResponse execute(CreateShopRequest request, ShopRepositoryInterface repository,
                                      @Nullable ShopServiceInterface serviceInterface){
        CreateShopResponse response = null;
        Shop addedShop = new Shop(request.getName());
        try {
            serviceInterface.add(addedShop);
            response = new CreateShopResponse(addedShop);
        } catch (Exception e) {
            //Switch exception type here
            e.printStackTrace();
            response = new CreateShopResponse(null);
            response.setException(e);
        }

        return response;
    }
}
