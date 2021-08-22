package com.xampydrivesell.userShopService.userInterface.controller;

import com.xampydrivesell.userShopService.domain.dto.request.GetAllShopRequest;
import com.xampydrivesell.userShopService.domain.dto.response.shop.GetAllShopResponse;
import com.xampydrivesell.userShopService.domain.useCase.shop.GetAllShopsUseCase;
import com.xampydrivesell.userShopService.infrastructure.adapter.primary.service.ShopService;
import com.xampydrivesell.userShopService.userInterface.presenter.GetAllShopPresenter;
import com.xampydrivesell.userShopService.userInterface.viewModel.ShopsViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/shops")
public class GetAllShopController {

    private final GetAllShopsUseCase getAllShopsUseCase;
    private final GetAllShopPresenter getAllShopsPresenter;
    private final ShopService shopService;

    @Autowired
    public GetAllShopController(GetAllShopsUseCase getAllShopsUseCase, GetAllShopPresenter getAllShopPresenter, ShopService shopService){
        this.getAllShopsUseCase = getAllShopsUseCase;
        this.getAllShopsPresenter = getAllShopPresenter;
        this.shopService = shopService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ShopsViewModel getShops(){
        GetAllShopRequest request = new GetAllShopRequest();
        GetAllShopResponse response = this.getAllShopsUseCase.execute(request, null, this.shopService);

        return this.getAllShopsPresenter.present(response);
    }
}
