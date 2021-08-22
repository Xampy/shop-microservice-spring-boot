package com.xampydrivesell.userShopService.domain.dto.response.shop;

import com.xampydrivesell.userShopService.domain.dto.response.UseCaseResponseInterface;
import com.xampydrivesell.userShopService.domain.entity.Shop;

public class GetSingleShopResponse implements UseCaseResponseInterface {
    /**
     * @var shop
     */
    private Shop shop;

    /**
     * Class constructor
     * @param shop
     */
    public GetSingleShopResponse(Shop shop){
        this.shop = shop;
    }

    public Shop getShop() {
        return this.shop;
    }
}
