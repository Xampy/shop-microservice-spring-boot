package com.xampydrivesell.userShopService.userInterface.presenter;


import com.xampydrivesell.userShopService.domain.port.secondary.presenter.GetAllShopPresenterInterface;
import com.xampydrivesell.userShopService.domain.dto.response.shop.GetAllShopResponse;
import com.xampydrivesell.userShopService.userInterface.viewModel.ShopsViewModel;
import org.springframework.stereotype.Service;


@Service
public class GetAllShopPresenter implements GetAllShopPresenterInterface {

    @Override
    public ShopsViewModel present(GetAllShopResponse response) {
        return  new ShopsViewModel(response.getShops());
    }
}
