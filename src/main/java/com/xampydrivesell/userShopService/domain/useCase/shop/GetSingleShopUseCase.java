package com.xampydrivesell.userShopService.domain.useCase.shop;

import com.xampydrivesell.userShopService.domain.dto.request.GetSingleShopRequest;
import com.xampydrivesell.userShopService.domain.dto.response.shop.GetSingleShopResponse;
import com.xampydrivesell.userShopService.domain.port.primary.service.ShopServiceInterface;
import com.xampydrivesell.userShopService.domain.port.secondary.repository.ShopRepositoryInterface;
import com.xampydrivesell.userShopService.domain.share.exception.CustomException;
import com.xampydrivesell.userShopService.domain.useCase.AbstractUseCase;
import org.springframework.lang.Nullable;

public class GetSingleShopUseCase extends AbstractUseCase<GetSingleShopRequest, GetSingleShopResponse> {
    @Override
    public GetSingleShopResponse execute(GetSingleShopRequest request, ShopRepositoryInterface repository,
                                         @Nullable ShopServiceInterface serviceInterface) throws CustomException {
        return new GetSingleShopResponse( repository.getByName(request.getName()) );
    }
}
