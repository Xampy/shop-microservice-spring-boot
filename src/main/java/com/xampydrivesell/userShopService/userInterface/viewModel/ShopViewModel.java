package com.xampydrivesell.userShopService.userInterface.viewModel;

import com.xampydrivesell.userShopService.domain.entity.Shop;

public class ShopViewModel {

    /**
     * @var shop a shop object
     */
    private Shop shop;

    public ShopViewModel(Shop shop) {
        this.shop = shop;
    }

    public ShopViewModel() {
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
