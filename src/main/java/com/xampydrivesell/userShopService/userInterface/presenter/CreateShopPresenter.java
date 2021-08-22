package com.xampydrivesell.userShopService.userInterface.presenter;

import com.xampydrivesell.userShopService.domain.dto.response.shop.CreateShopResponse;
import com.xampydrivesell.userShopService.domain.port.secondary.presenter.CreateShopPresenterInterface;
import com.xampydrivesell.userShopService.userInterface.viewModel.ShopViewModel;
import org.springframework.stereotype.Service;

@Service
public class CreateShopPresenter implements CreateShopPresenterInterface {
    @Override
    public ShopViewModel present(CreateShopResponse response) {
        return new ShopViewModel(response.getShop());
    }
}
