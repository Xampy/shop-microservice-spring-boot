package com.xampydrivesell.userShopService.userInterface.controller;

import com.xampydrivesell.userShopService.domain.dto.request.CreateShopRequest;
import com.xampydrivesell.userShopService.domain.dto.response.shop.CreateShopResponse;
import com.xampydrivesell.userShopService.domain.share.exception.ShopNameAlreadyExistsException;
import com.xampydrivesell.userShopService.domain.useCase.shop.CreateShopUseCase;
import com.xampydrivesell.userShopService.infrastructure.adapter.primary.service.ShopService;
import com.xampydrivesell.userShopService.userInterface.presenter.CreateShopPresenter;
import com.xampydrivesell.userShopService.userInterface.viewModel.ShopViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/shops")
public class CreateShopController {

    private final ShopService shopService;
    private final CreateShopPresenter presenter;

    @Autowired
    public CreateShopController(ShopService shopService, CreateShopPresenter presenter) {
        this.shopService = shopService;
        this.presenter = presenter;
    }

    /**
     * Create a new shop with the provided name
     * @param body a json content of name and description
     * @return
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ShopViewModel createShop(@RequestBody ActionRequest body){
        CreateShopRequest request = new CreateShopRequest(body.getName());
        CreateShopUseCase useCase = new CreateShopUseCase();

        CreateShopResponse response = useCase.execute(request, null, shopService);
        if(response.getException() != null){
            if(response.getException() instanceof ShopNameAlreadyExistsException){
                throw  new ResponseStatusException(HttpStatus.FORBIDDEN, "The shop name is already used");
            }else{
                throw  new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown error occurred");
            }

        }

        return this.presenter.present(response);
    }


    static class ActionRequest {
        private String name;
        private String description;

        public ActionRequest(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public ActionRequest() {}

        public String getName() {return name;}
        public void setName(String name) {this.name = name;}

        public String getDescription() {return description;}
        public void setDescription(String description) {this.description = description;}
    }
}
