package com.xampydrivesell.userShopService.domain.useCase;

import com.xampydrivesell.userShopService.domain.dto.request.UseCaseRequestInterface;
import com.xampydrivesell.userShopService.domain.dto.response.UseCaseResponseInterface;
import com.xampydrivesell.userShopService.domain.port.primary.service.ShopServiceInterface;
import com.xampydrivesell.userShopService.domain.port.secondary.repository.ShopRepositoryInterface;
import com.xampydrivesell.userShopService.domain.share.exception.CustomException;
import org.springframework.lang.Nullable;

public abstract class AbstractUseCase<I, O> {

    public abstract O execute(I request, ShopRepositoryInterface repository, @Nullable ShopServiceInterface serviceInterface) throws CustomException;
}
