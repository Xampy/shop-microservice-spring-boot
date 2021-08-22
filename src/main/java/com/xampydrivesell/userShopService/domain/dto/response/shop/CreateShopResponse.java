package com.xampydrivesell.userShopService.domain.dto.response.shop;

import com.xampydrivesell.userShopService.domain.dto.response.UseCaseResponseInterface;
import com.xampydrivesell.userShopService.domain.entity.Shop;

public class CreateShopResponse implements UseCaseResponseInterface {
    /**
     * @var shop an object
     */
    private Shop shop;

    /**
     * @var exception an exception during the case execution
     */
    private Exception exception;

    /**
     * Class constructor
     * @param shop
     */
    public CreateShopResponse(Shop shop){
        this.shop = shop;
    }

    public Shop getShop() {
        return this.shop;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
