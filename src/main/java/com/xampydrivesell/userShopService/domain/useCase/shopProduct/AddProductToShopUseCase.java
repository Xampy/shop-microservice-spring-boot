package com.xampydrivesell.userShopService.domain.useCase.shopProduct;

import com.xampydrivesell.userShopService.domain.dto.request.shopProduct.AddProductToShopRequest;
import com.xampydrivesell.userShopService.domain.dto.response.shopProduct.AddProductToShopResponse;
import com.xampydrivesell.userShopService.domain.port.primary.service.ShopServiceInterface;
import com.xampydrivesell.userShopService.domain.port.secondary.repository.ShopRepositoryInterface;
import com.xampydrivesell.userShopService.domain.share.exception.CustomException;
import com.xampydrivesell.userShopService.domain.useCase.AbstractUseCase;

public class AddProductToShopUseCase extends AbstractUseCase<AddProductToShopRequest, AddProductToShopResponse> {
    @Override
    public AddProductToShopResponse execute(AddProductToShopRequest request, ShopRepositoryInterface repository,
                                            ShopServiceInterface serviceInterface) throws CustomException {

        AddProductToShopResponse response = new AddProductToShopResponse();

        //Validate the request data
        //[NOT HANDLED]

        return response;
    }
}
