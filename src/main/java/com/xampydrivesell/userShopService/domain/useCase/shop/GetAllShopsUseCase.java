package com.xampydrivesell.userShopService.domain.useCase.shop;

import com.xampydrivesell.userShopService.domain.dto.request.GetAllShopRequest;
import com.xampydrivesell.userShopService.domain.dto.response.shop.GetAllShopResponse;
import com.xampydrivesell.userShopService.domain.entity.Shop;
import com.xampydrivesell.userShopService.domain.port.primary.service.ShopServiceInterface;
import com.xampydrivesell.userShopService.domain.port.secondary.repository.ShopRepositoryInterface;
import com.xampydrivesell.userShopService.domain.useCase.AbstractUseCase;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * GetAllShopsUseCase class
 */
@Component
public class GetAllShopsUseCase extends AbstractUseCase<GetAllShopRequest, GetAllShopResponse > {

    /**
     * Execute the use case
     * @param request the input to the use case
     * @param repository a data repository. It can be null
     * @param service a service for managing data
     * @return a response
     */
    public GetAllShopResponse execute(GetAllShopRequest request, ShopRepositoryInterface repository,
                                      @NonNull  ShopServiceInterface service){
        Shop[] shops = service.getAllShop().toArray(Shop[]::new);
        return new GetAllShopResponse(shops);
    }
}
