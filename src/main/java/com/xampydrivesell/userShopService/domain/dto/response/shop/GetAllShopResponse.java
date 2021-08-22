package com.xampydrivesell.userShopService.domain.dto.response.shop;

import com.xampydrivesell.userShopService.domain.dto.response.UseCaseResponseInterface;
import com.xampydrivesell.userShopService.domain.entity.Shop;

/**
 * class GetAllShopResponse
 */
public class GetAllShopResponse implements UseCaseResponseInterface {
    /**
     * @var shops
     */
    private Shop[] shops;

    /**
     * Class constructor
     * @param shops
     */
    public GetAllShopResponse(Shop[] shops){
        this.shops = shops;
    }

    public Shop[] getShops() {
        return shops;
    }
}
